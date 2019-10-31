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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
