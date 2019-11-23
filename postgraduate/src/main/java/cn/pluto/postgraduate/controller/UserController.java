package cn.pluto.postgraduate.controller;

import cn.pluto.postgraduate.pojo.User;
import cn.pluto.postgraduate.service.UserService;
import cn.pluto.postgraduate.untils.ConstantConfig;
import cn.pluto.postgraduate.untils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zqq
 * @create 2019-11-15-14:40
 */
@RestController
public class UserController {

    @Autowired
    private  UserService userService;

    private User user;


    /**
     * @Description: 处理登录请求
     * @param: username,password
     * @return: Result
     * @auther: zqq
     * @date: 19/11/16 11:51
     */
    @PostMapping("/user/login")
    public Result login(String username, String password, HttpSession session){
        //手动匹配
        if (StringUtils.isEmpty(username)){
            return Result.fail(-1,"账号不能为空");
        }else if (StringUtils.isEmpty(password)){
            return Result.fail(-1,"密码不能为空");
        }else {
            user = new User();
            user.setUsername(username);
            user.setPassword(password);
            List<User> users = userService.doLogin(user);
            if (!users.isEmpty()){//该账户存在
                if (users.get(0).getPassword().equals(user.getPassword())){//密码正确
                    session.setAttribute(ConstantConfig.SESSION_USER,username);
                    return Result.success(users.get(0).getSchoolname());
                }else {
                    return Result.fail(-1,"密码不正确");
                }
            }else {
                return Result.fail(-1,"账号不存在");
            }
        }
    }

    /**
     * @Description: 注册账户信息
     * @param: schoolname、username、password
     * @return: Result
     * @auther: zqq
     * @date: 19/11/22 8:49
     */
    @PostMapping("/user/register")
    public Result register(String schoolname,String username,String password){
        if (StringUtils.isEmpty(schoolname)){
            return Result.fail(-1,"学校名称不能为空");
        }else if (StringUtils.isEmpty(username)){
            return Result.fail(-1,"账户名不能为空");
        }else if (StringUtils.isEmpty(password)){
            return Result.fail(-1,"密码不能为空");
        }else {
            user = new User();
            user.setSchoolname(schoolname);
            user.setUsername(username);
            user.setPassword(password);
            Boolean regBool = userService.doRegister(user);
            if (regBool){
                return Result.success();
            }
            return Result.fail(-1,"注册失败");
        }
    }
    
    /**
     * @Description: 查询所有学校信息
     * @param: 
     * @return: 
     * @auther: zqq
     * @date: 19/11/22 14:39
     */
    @GetMapping("/user/school")
    public Result school(){
        List<User> allUser = userService.getAllUser();
        return Result.success(allUser);
    }

}
