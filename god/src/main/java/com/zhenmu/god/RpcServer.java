package com.zhenmu.god;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author by xuzhen4.
 * @version: V1.0.
 * @description: rpc服务监听.
 * @create: 2019-7-24 9:01
 */
@Slf4j
@Component
public class RpcServer {
    //创建线程池
    private static final ExecutorService executorService=Executors.newCachedThreadPool();

}
