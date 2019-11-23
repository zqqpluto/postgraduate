package cn.pluto.postgraduate.service;

import cn.pluto.postgraduate.dao.UserMapper;
import cn.pluto.postgraduate.pojo.Excelpath;
import cn.pluto.postgraduate.pojo.ExcelpathExample;
import cn.pluto.postgraduate.pojo.User;
import cn.pluto.postgraduate.pojo.UserExample;
import cn.pluto.postgraduate.untils.ConstantConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zqq
 * @create 2019-11-15-15:32
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserExample userExample;

    /**
     * @Description: 判断账号是否存在，若存在，判断账号密码是否匹配
     * @param: User
     * @return:
     * @auther: zqq
     * @date: 19/11/16 11:47
     */
    public List<User> doLogin(User user) {
        userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        List<User> users= userMapper.selectByExample(userExample);
        return users;
    }

    /**
     * @Description: 根据username查询所有user、信息
     * @param:
     * @return:
     * @auther: zqq
     * @date: 19/11/19 19:50
     */
    public User getInfoByUserName(User user) {
        userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        List<User> users = userMapper.selectByExample(userExample);
        return users.get(0);
    }

    /**
     * @Description: 插入账户信息，插入成功返回true，否则饭后false
     * @param: 
     * @return: 
     * @auther: zqq
     * @date: 19/11/22 9:42
     */
    public Boolean doRegister(User user) {
        return userMapper.insertSelective(user) == 1 ? true : false;
    }

    /**
     * @Description: 查询所有账户信息
     * @param: 
     * @return: 
     * @auther: zqq
     * @date: 19/11/22 14:33
     */
    public List<User> getAllUser() {
        userExample = new UserExample();
        List<User> users = userMapper.selectByExample(userExample);
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            iterator.next().setPassword("");
        }
        return users;
    }

    /**
     * @Description: 通过id获取该user的信息
     * @param:
     * @return:
     * @auther: zqq
     * @date: 19/11/22 18:50
     */
    public User getInfoById(User user) {
        return userMapper.selectByPrimaryKey(user.getId());
    }
}
