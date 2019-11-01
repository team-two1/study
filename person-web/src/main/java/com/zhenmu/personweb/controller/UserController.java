package com.zhenmu.personweb.controller;

import com.zhenmu.personservice.api.UserApi;
import com.zhenmu.personservice.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author by xuzhen4.
 * @version: V1.0.
 * @description: 用户管理.
 * @create: 2019-8-22 9:23
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserApi userApi;

    @RequestMapping("/login")
    public String login(){
        String result = null;
        try{
            result = userApi.login();
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/register")
    public String register(@RequestBody User user){
        return userApi.register(user);
    }

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        model.addObject("name", "jack");
        model.addObject("age", 20);
        model.addObject("info", "我是一个爱学习的好青年");
        model.setViewName("login");
        return model;
    }
}
