package com.zhenmu.personservice.api.impl;

import com.zhenmu.personservice.api.UserApi;
import com.zhenmu.personservice.entity.User;
import com.zhenmu.personservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author by xuzhen4.
 * @version: V1.0.
 * @description: 用户管理.
 * @create: 2019-8-22 9:01
 */
@Service
public class UserApiImpl implements UserApi {

    @Autowired
    private UserService userService;

    @Override
    public String login(){
        return userService.login();
    }

    @Override
    public String register(User user) {
        return userService.register(user);
    }
}
