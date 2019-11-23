package cn.pluto.postgraduate.config;

import cn.pluto.postgraduate.intercepter.LoginHandlerIntercepter;
import cn.pluto.postgraduate.intercepter.MyLocaleResolver;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

/**
 * @author zqq
 * @create 2019-11-02-11:24
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {

//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/login.html").setViewName("login");
//                registry.addViewController("/").setViewName("index");
//                registry.addViewController("/index.html").setViewName("index");
//                registry.addViewController("/register.html").setViewName("register");
//                registry.addViewController("/main.html").setViewName("dashboard");
//                registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//            }

//            拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
//                 不拦截的请求
                registry.addInterceptor(new LoginHandlerIntercepter()).addPathPatterns("/**").excludePathPatterns(
                        "/", "/login.html", "/index.html", "/register.html", "/asserts/**", "/webjars/**",
                        "/user/login", "/user/register","/user/school","/user/school","/excel/info","/excel/infoExcel"
                ,"/excel/score");
            }
        };
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}
