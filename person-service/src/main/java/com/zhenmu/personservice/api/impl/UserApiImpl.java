package com.zhenmu.personservice.api.impl;

import com.zhenmu.personservice.api.UserApi;
import org.springframework.stereotype.Service;

/**
 * @author by xuzhen4.
 * @version: V1.0.
 * @description: 用户管理.
 * @create: 2019-8-22 9:01
 */
@Service
public class UserApiImpl implements UserApi {

    @Override
    public String login(){
        return "service OK";
    }
}
