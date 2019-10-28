package com.zhenmu.god;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author by xuzhen4.
 * @version: V1.0.
 * @description: .
 * @create: 2019-7-24 9:54
 */
public class ServerDemo {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{Date endDate = sdf.parse(null);} catch (Exception e){
            e.printStackTrace();
        }

        //之前发布服务
/*
        RpcServer rpcServer = new RpcServer();
        rpcServer.publisher(new HelloServiceImpl(),12345);
*/
//        //改造后
//        IRegistryCenter registryCenter = new RegistryCenterImpl();
//        //这里为了方便，获取ip地址就直接写了
//        RpcServer rpcServer = new RpcServer(registryCenter,"127.0.0.1:12345");
//        //绑定服务
//        rpcServer.bind(new RPCClientServiceImpl());
//        rpcServer.publisher();
    }
}
