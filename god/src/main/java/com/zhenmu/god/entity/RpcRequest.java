package com.zhenmu.god.entity;

import lombok.Data;

/**
 * @author by xuzhen4.
 * @version: V1.0.
 * @description: .
 * @create: 2019-7-24 9:36
 */
@Data
public class RpcRequest {

    private String className;

    private String methodName;

    private Object[] parameters;
}
