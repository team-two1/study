package com.zhenmu.personservice.entity;

import lombok.Data;

/**
 * @author by xuzhen4.
 * @version: V1.0.
 * @description: 用户信息.
 * @create: 2019-8-23 14:29
 */
@Data
public class User {

    private Long id;

    private String userName;

    private String password;

    private String phone;
}
