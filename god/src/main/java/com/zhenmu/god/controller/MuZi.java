package com.zhenmu.god.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by xuzhen4.
 * @version: V1.0.
 * @description: RPC框架测试.
 * @create: 2019-7-20 9:55
 */
@RestController
@RequestMapping(value = "god")
public class MuZi {

    @RequestMapping(value = "/testAlive", method = RequestMethod.GET)
    @ResponseBody
    public void testAlive(){
        System.out.println("I am alive");
    }
}
