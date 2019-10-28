package com.zhenmu.water.service.impl;

import com.zhenmu.water.entity.User;
import com.zhenmu.water.service.RPCClientService;
import org.springframework.stereotype.Service;

/**
 * @author by xuzhen4.
 * @version: V1.0.
 * @description: RPC框架测试.
 * @create: 2019-7-20 10:28
 */
@Service
public class RPCClientServiceImpl implements RPCClientService {

    @Override
    public String rpcTest(String content){
        return "调用成功";
    }

    @Override
    public User selectById(Integer id) {
        User user=new User();
        user.setUsername("张三");
        user.setId(id);
        user.setMessage("张三是胖子");
        System.out.println("UserService调用了selectById()方法查询用户.....");
        return user;
    }
}
