package com.zhenmu.god.service.impl;

import com.zhenmu.god.config.RegistryCenterConfig;
import com.zhenmu.god.service.IRegistryCenter;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * @author by xuzhen4.
 * @version: V1.0.
 * @description: 注册中心实现类.
 * @create: 2019-7-23 17:25
 */
public class RegistryCenterImpl implements IRegistryCenter {

    private CuratorFramework curatorFramework;
    {
        curatorFramework = CuratorFrameworkFactory.builder()
                .connectString(RegistryCenterConfig.CONNECTING_STR)
                .sessionTimeoutMs(RegistryCenterConfig.SESSION_TIMEOUT)
                .retryPolicy(new ExponentialBackoffRetry(1000, 10)).build();
        curatorFramework.start();
    }

    @Override
    public void register(String serviceName, String serviceAddress){
        String serviceNodePath = RegistryCenterConfig.NAMESPACE + "/" + serviceName;
        try{
            //如果serviceNodePath（/rpcNode/userService）不存在就创建
            if(curatorFramework.checkExists().forPath(serviceNodePath) == null){
                //持久化节点
                curatorFramework.create()
                        .creatingParentContainersIfNeeded()
                        .withMode(CreateMode.PERSISTENT)
                        .forPath(serviceNodePath, RegistryCenterConfig.DEFAULT_VALUE);
            }
            //注册的服务的节点路径
            String addressPath = serviceNodePath + "/" + serviceAddress;
            //临时节点
            String rsNode = curatorFramework.create().creatingParentsIfNeeded()
                    .withMode(CreateMode.EPHEMERAL)
                    .forPath(addressPath, RegistryCenterConfig.DEFAULT_VALUE);
            System.out.println("服务注册成功：" + rsNode);
        }catch (Exception e){
            System.out.println("服务注册异常");
            e.printStackTrace();
        }
    }
}
