package cn.pluto.postgraduate.service;

import cn.pluto.postgraduate.dao.ExcelpathMapper;
import cn.pluto.postgraduate.pojo.Excelpath;
import cn.pluto.postgraduate.pojo.ExcelpathExample;
import cn.pluto.postgraduate.pojo.User;
import cn.pluto.postgraduate.untils.ConstantConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zqq
 * @create 2019-11-19-19:37
 */
@Service
public class ExcelService {

    @Autowired
    private ExcelpathExample excelpathExample;

    @Autowired
    private ExcelpathMapper excelpathMapper;
    
    

    /**
     * @Description: 根据user信息查询所有该user的excel文件信息
     * @param:
     * @return:
     * @auther: zqq
     * @date: 19/11/20 11:09
     */
    public List<Excelpath> getExcels(User userback) {
        excelpathExample = new ExcelpathExample();
        ExcelpathExample.Criteria criteria = excelpathExample.createCriteria();
        criteria.andUserIdEqualTo(userback.getId());
        List<Excelpath> excelpaths = excelpathMapper.selectByExample(excelpathExample);
        return  excelpaths;
    }

    /**
     * @Description: 文件上传
     * @param:
     * @return:
     * @auther: zqq
     * @date: 19/11/20 14:08
     */
    public Boolean upExcel(MultipartFile excel,User userback) {
        String filename = excel.getOriginalFilename();//获取文件名
        String filePath = ConstantConfig.ExcelFirstPath+userback.getUsername()+"/"+filename;//文件全路径
        File file = new File(filePath);
        if (!file.getParentFile().exists()){//判断父目录是否存在
            file.getParentFile().mkdirs();//不存在则创建
        }
        try {
            excel.transferTo(file);//保存文件
            //建立模型
            String [] args = new String[]{"python","D:/SpringUpload/model.py",filePath};
            runPython(args);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Excelpath excelpath = new Excelpath();
        excelpath.setUserId(userback.getId());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        excelpath.setExcelTime(simpleDateFormat.format(new Date()));
        excelpath.setExcelPath(filename);
        int insert = excelpathMapper.insert(excelpath);
        return insert == 1 ? true:false;
    }

    /**
     * @Description: 根据user_id获取excel信息
     * @param: 
     * @return: 
     * @auther: zqq
     * @date: 19/11/22 19:29
     */
    public List<Excelpath> getExcel(Excelpath excelpath) {
        excelpathExample = new ExcelpathExample();
        ExcelpathExample.Criteria criteria = excelpathExample.createCriteria();
        criteria.andUserIdEqualTo(excelpath.getUserId());
        List<Excelpath> excelpaths = excelpathMapper.selectByExample(excelpathExample);
        return excelpaths;
    }

    /**
     * @Description: 将各科成绩匹配出来，存放在list里面
     * @param: 
     * @return: 
     * @auther: zqq
     * @date: 19/11/23 9:58
     */
    public List<String> getScore(String data) {
        List<String> strings = new ArrayList<>();//初始化各科成绩
        String pattern = "=[1-9]+(\\.\\d+)?";//正则表达式获取=号之后的数字
        Pattern r = Pattern.compile(pattern);
        Matcher matcher = r.matcher(data);
        while (matcher.find()){
            strings.add(matcher.group().split("=")[1]);
        }
        return strings;
    }

    public List<String> getPostgraduate(List<String> stringList, User userServiceInfoById, Excelpath excelpath) {
        List<String> strings = new ArrayList<>();
        String line = "";
        stringList.remove(0);
        stringList.remove(0);
        String filePath = ConstantConfig.ExcelFirstPath+userServiceInfoById.getUsername()+"/"+excelpath.getExcelPath();
        String args[] = new String[]{"python","D:/SpringUpload/getScore.py",filePath, String.valueOf(stringList)};
        try {
            line = runPython(args);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String[] split = line.split(" ");
        for (int i = 0; i < split.length; i++) {
            strings.add(split[i]+"%");
        }
        return strings;
    }

    /**
     * @Description: 运行python文件的方法
     * @param:
     * @return:
     * @auther: zqq
     * @date: 19/11/23 10:22
     */
    private String runPython(String[] args) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec(args);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = bufferedReader.readLine();
        bufferedReader.close();
        process.waitFor();
        return line;
    }

    /**
     * @Description: 查询该校的所有excel表信息
     * @param: 
     * @return: 
     * @auther: zqq
     * @date: 19/11/23 13:00
     */
    public List<Excelpath> getExcelByUserId(Excelpath excelpath) {
        excelpathExample = new ExcelpathExample();
        ExcelpathExample.Criteria criteria = excelpathExample.createCriteria();
        criteria.andUserIdEqualTo(excelpath.getUserId());
        return excelpathMapper.selectByExample(excelpathExample);
    }

    /**
     * @Description: 通过id主键获取excel表信息
     * @param:
     * @return:
     * @auther: zqq
     * @date: 19/11/23 13:01
     */
    public Excelpath getExcelById(Excelpath excelpath) {
        return excelpathMapper.selectByPrimaryKey(excelpath.getId());
    }

    /**
     * @Description: 删除文件和删除数据库
     * @param: 
     * @return: 
     * @auther: zqq
     * @date: 19/11/23 14:07
     */
    public Boolean delFile(Excelpath excelById, User userServiceInfoById) {
        int i = excelpathMapper.deleteByPrimaryKey(excelById.getId());
        String filePath = ConstantConfig.ExcelFirstPath+userServiceInfoById.getUsername()+"/"+excelById.getExcelPath();
        String fileModel1 = filePath + "-linearmodel";
        String fileModel2 = filePath + "-gaussianNBmodel";
        String fileModel3 = filePath + "-decisionTreemodel";
        String fileModel4 = filePath + "-logisticmodel";
        File file1 = new File(filePath);
        File file2 = new File(fileModel1);
        File file3 = new File(fileModel2);
        File file4 = new File(fileModel3);
        File file5 = new File(fileModel4);
        file1.delete();
        file2.delete();
        file3.delete();
        file4.delete();
        file5.delete();
        return i == 1 ? true : false;
    }
}
