package com.zhenmu.water.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by xuzhen4.
 * @version: V1.0.
 * @description: .
 * @create: 2019-7-20 10:51
 */
@RestController
@RequestMapping("/water")
public class Sea {

    @RequestMapping(value = "/creat", method = RequestMethod.GET)
    public void creat(){
        System.out.println("waterCreat");
    }
}
