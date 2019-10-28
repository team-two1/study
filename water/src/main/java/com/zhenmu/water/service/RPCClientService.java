package com.zhenmu.water.service;

import com.zhenmu.water.entity.User;

public interface RPCClientService {

    String rpcTest(String content);

    User selectById(Integer id);
}
