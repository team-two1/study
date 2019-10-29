package com.zhenmu.personweb.controller;

import com.zhenmu.personservice.api.UserApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
