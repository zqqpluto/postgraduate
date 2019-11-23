package cn.pluto.postgraduate.untils;

import com.sun.org.apache.bcel.internal.classfile.Code;
import com.sun.org.apache.regexp.internal.REUtil;
import jdk.nashorn.internal.ir.ReturnNode;

/**
 * @author zqq
 * @create 2019-11-14-19:16
 */
public class Result {
    private int code;       //状态码
    private String msg;     //一些提示信息
    private Object data;    //返回的数据

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result success(){
        Result res = new Result();
        res.setCode(200);
        return res;
    }

    //请求成功返回数据给前端
    public static Result success(Object data){
        Result res = new Result();
        res.setCode(200);
        res.setData(data);
        return res;
    }

    //请求失败返回信息和状态码
    public static Result fail(int code,String message){
        Result res = new Result();
        res.setCode(code);
        res.setMsg(message);
        return res;
    }
}
