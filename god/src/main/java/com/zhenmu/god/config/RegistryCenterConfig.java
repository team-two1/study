package com.zhenmu.god.config;

/**
 * @author by xuzhen4.
 * @version: V1.0.
 * @description: 注册中心配置.
 * @create: 2019-7-23 17:31
 */
public class RegistryCenterConfig {

    /**
     * ZK地址int
     */
    public static String CONNECTING_STR = "192.168.220.136,192.168.220.137";

    public static int SESSION_TIMEOUT = 4000;

    /**
     * 注册中心namespace
     */
    public static String NAMESPACE = "/rpcNode";

    /**
     * value一般来说作用不大；一般主要是利用节点特性搞点事情
     */
    public static byte[] DEFAULT_VALUE = "0".getBytes();
}
