package com.zhenmu.personservice.service.impl;

import com.zhenmu.personservice.entity.User;
import com.zhenmu.personservice.mapper.UserMapper;
import com.zhenmu.personservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author by xuzhen4.
 * @version: V1.0.
 * @description: 用户管理.
 * @create: 2019-8-22 17:03
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public String register(User user) {
        userMapper.saveuser(user);
        return "success";
    }

    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(){
        User user = userMapper.queryById(1L);
        System.out.println(user.toString());
        return "service OK";
    }




}
