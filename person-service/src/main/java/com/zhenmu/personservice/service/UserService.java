package com.zhenmu.personservice.service;


import com.zhenmu.personservice.entity.User;

public interface UserService {

    String login();

    String register(User user);

}
