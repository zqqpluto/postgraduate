package cn.pluto.postgraduate.controller;

import cn.pluto.postgraduate.pojo.Excelpath;
import cn.pluto.postgraduate.pojo.User;
import cn.pluto.postgraduate.service.ExcelService;
import cn.pluto.postgraduate.service.UserService;
import cn.pluto.postgraduate.untils.ConstantConfig;
import cn.pluto.postgraduate.untils.Result;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import scala.Int;

import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zqq
 * @create 2019-11-19-19:36
 */
@RestController
public class ExcelController {
    @Autowired
    private ExcelService excelService;

    @Autowired
    private UserService userService;



    private static final String XLS = "xls";
    private static final String XLSX = "xlsx";

    /**
     * @Description: 查询所有改用的所有上传文件信息
     * @param: 
     * @return: 
     * @auther: zqq
     * @date: 19/11/20 11:34
     */
    @GetMapping("/files")
    public Result getExcels(HttpSession session){
        String username = (String) session.getAttribute(ConstantConfig.SESSION_USER);
        User user = new User();
        user.setUsername(username);
        User userback = userService.getInfoByUserName(user);
        List<Excelpath> excels = excelService.getExcels(userback);
        return Result.success(excels);
    }

    /**
     * @Description: excel上传
     * @param:
     * @return:
     * @auther: zqq
     * @date: 19/11/20 14:03
     */
    @PostMapping("/files")
    public Result upExcel(@RequestParam("file") MultipartFile file,HttpSession session){
        if (file.isEmpty()){
            return Result.fail(-1,"文件上传为空");
        }else {
            User user = new User();
            user.setUsername((String) session.getAttribute(ConstantConfig.SESSION_USER));
            User userback = userService.getInfoByUserName(user);
            Boolean bool = excelService.upExcel(file, userback);
            if (bool){
                return Result.success();
            }
            return Result.fail(-2,"文件上传失败");
        }
    }

    /**
     * @Description: 获取表格的标签信息
     * @param: 
     * @return: 
     * @auther: zqq
     * @date: 19/11/22 21:20
     */
    @GetMapping("/excel/infoExcel")
    public Result getInfoExcel(String id){
        List tableList = new ArrayList();

        //通过id获取excel表信息
        Excelpath excelpath = new Excelpath();
        excelpath.setId(Integer.valueOf(id));
        Excelpath el = excelService.getExcelById(excelpath);

        //通过excel的外键货物user表的信息
        User user = new User();
        user.setId(el.getUserId());
        User userServiceInfoById= userService.getInfoById(user);

        if (userServiceInfoById != null && el != null){
            String filePath =
                    ConstantConfig.ExcelFirstPath+userServiceInfoById.getUsername()+"/"+el.getExcelPath();
            String fileType = filePath.substring(filePath.lastIndexOf("."));//获取后缀名
            //2003版本
            //Workbook workbook = new HSSFWorkbook(is);
            //2007版本
            //Workbook workbook = new XSSFWorkbook(is);
            //推荐使用poi-ooxml中的WorkbookFactory.create(is)来创建Workbook,因为HSSFWorkbook和XSSFWorkbook都实现了Workbook接口
            FileInputStream is = null;
            try {
                is = new FileInputStream(new File(filePath));
                Workbook wbc = WorkbookFactory.create(is);
                Sheet sheet = wbc.getSheetAt(0);
                Row row = sheet.getRow(0);//第一行
                int colNum = row.getPhysicalNumberOfCells();//第一行格数
                for (int i = 1; i < colNum-1; i++) {//抛出第一栏序号和最后一栏的标签
                    tableList.add(row.getCell(i).toString());
//                    System.out.println("title======="+row.getCell(i).toString());
//                    row.getCell(i)
                }
                return Result.success(tableList);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Result.fail(-1,"该校未录入考研数据");
    }

    /**
     * @Description: 对提交的数据进行处理
     * @param: 
     * @return: 
     * @auther: zqq
     * @date: 19/11/22 22:08
     */
    @PostMapping("/excel/score")
    public Result data(String data){
        List<String> strings = excelService.getScore(data);//第一个数为学校的id，后面的数为成绩
        User user = new User();
        user.setId(Integer.valueOf(strings.get(0)));
        User userServiceInfoById = userService.getInfoById(user);//user的信息
        Excelpath excelpath = new Excelpath();
        excelpath.setUserId(Integer.valueOf(strings.get(0)));
        List<Excelpath> excel = excelService.getExcel(excelpath);//excel表的信息
        List<String> postgraduate = excelService.getPostgraduate(strings, userServiceInfoById, excel.get(0));
        for (String s : postgraduate) {
            System.out.println("s = " + s);
        }
        return Result.success(postgraduate);
    }

    /**
     * @Description: 查询所有excel表信息
     * @param: 
     * @return: 
     * @auther: zqq
     * @date: 19/11/23 12:43
     */
    @GetMapping("/excel/info")
    public Result info(String id){
        Excelpath excelpath = new Excelpath();
        excelpath.setUserId(Integer.valueOf(id));
        List<Excelpath> excelpathList = excelService.getExcelByUserId(excelpath);
        return Result.success(excelpathList);
    }

    @DeleteMapping("/file/{id}")
    public Result delFile(@PathVariable Integer id){
        System.out.println("进入删除");
        Excelpath excelpath = new Excelpath();
        excelpath.setId(id);
        Excelpath excelById = excelService.getExcelById(excelpath);
        User user = new User();
        user.setId(excelById.getUserId());
        User userServiceInfoById = userService.getInfoById(user);
        Boolean aBoolean = excelService.delFile(excelById, userServiceInfoById);
        return aBoolean == true ? Result.success() : Result.fail(-1,"删除失败");
    }
}
