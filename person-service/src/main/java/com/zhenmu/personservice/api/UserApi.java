package com.zhenmu.personservice.api;

import com.zhenmu.personservice.entity.User;

public interface UserApi {

    String login();

    String register(User user);
}
