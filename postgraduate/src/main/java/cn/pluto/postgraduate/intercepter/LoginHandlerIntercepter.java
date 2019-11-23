package cn.pluto.postgraduate.intercepter;

import cn.pluto.postgraduate.untils.ConstantConfig;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zqq
 * @create 2019-11-02-12:29
 * 登录拦截器
 */
public class LoginHandlerIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute(ConstantConfig.SESSION_USER);
        if (loginUser == null){
            //未登录，返回登陆界面
            request.setAttribute("msg","没有权限请先登录");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }else {
            //登录
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {

    }
}
