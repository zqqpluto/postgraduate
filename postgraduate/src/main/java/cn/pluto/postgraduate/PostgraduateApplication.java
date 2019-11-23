package cn.pluto.postgraduate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("cn.pluto.postgraduate.dao")
//@ComponentScan("cn.pluto.postgraduate.pojo")
@SpringBootApplication
public class PostgraduateApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostgraduateApplication.class, args);
    }

}
