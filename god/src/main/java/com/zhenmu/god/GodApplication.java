package com.zhenmu.god;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@MapperScan("com.zhenmu.personservice.mapper")
@ComponentScan(basePackages = {"com.zhenmu"})
public class GodApplication {
    public static void main(String[] args) {
        try{
            System.out.println("--------------启动ing---------------");
            SpringApplication.run(GodApplication.class, args);
        }catch (Exception e){
            e.printStackTrace();
        }
        //Provider.regist();
        System.out.println("--------------启动完成---------------");
    }

    @RequestMapping("hello")
    public String hello() {
        return "hello";
    }

}

