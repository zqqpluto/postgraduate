package cn.pluto.postgraduate.test;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zqq
 * @create 2019-11-21-16:36
 */
public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {
        String result = "";
        String filePath = "D:\\SpringUpload\\18781207453\\123.xlsx";
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(Double.valueOf(337));
        doubleList.add(Double.valueOf(118));
        doubleList.add(Double.valueOf(4));
        doubleList.add(4.5);
        doubleList.add(4.5);
        doubleList.add(9.56);
        doubleList.add(Double.valueOf(1));
        String [] cmd = new String[]{"python","D:\\SpringUpload\\getScore.py",filePath,String.valueOf(doubleList)};
        Process proc = Runtime.getRuntime().exec(cmd);
        BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        String line = null;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
            result += line;
        }
        in.close();
        proc.waitFor();
        System.out.println(result);

//        String exe = "python";
//        String command = "D:\\calculator_simple.py";
//        String num1 = "1";
//        String num2 = "2";
//        String[] cmdArr = new String[] {exe, command, num1, num2};
//        Process process = Runtime.getRuntime().exec(cmdArr);
//        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
//        String line = null;
//        while ((line = in.readLine()) != null) {
//            System.out.println(line);
//            result += line;
//        }
//        in.close();
//        process.waitFor();
//        System.out.println(result);

//        String str = "name=3&GRE%20Score=337&TOEFL%20Score=118&University%20Rating=4&SOP=4.5&LOR%20=4.5&CGPA=9.65&Research=1";
//        String pattern = "=[1-9]+(\\.\\d+)?";//正则表达式获取=号之后的数字
//        Pattern r = Pattern.compile(pattern);
//        Matcher matcher = r.matcher(str);
//        while (matcher.find()){
//            System.out.println(matcher.group().split("=")[1]);
//        }

    }
}
