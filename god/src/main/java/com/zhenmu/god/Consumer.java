package com.zhenmu.god;

import org.springframework.stereotype.Component;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * @author by xuzhen4.
 * @version: V1.0.
 * @description: .
 * @create: 2019-8-16 16:20
 */
@Component
public class Consumer {

    public static Object rpc(Class clazz){
        return Proxy.newProxyInstance(
                clazz.getClassLoader(),
                new Class[]{clazz},
                (proxy, method, args) ->
                        new InvocationHandler() {
                            //代理执行方法，上面设置了代理的类
                            @Override
                            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                                //1.建立远程连接
                                Socket socket = new Socket("127.0.0.1",8888);
                                //2.要调用的类、方法、参数
                                String apiName = clazz.getName();
                                String methodName = method.getName();
                                //为了鉴别方法的重载，这里需要传入参数类型
                                Class[] paramTypes = method.getParameterTypes();
                                //3.传输类信息，请求远程执行结果
                                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                                outputStream.writeUTF(apiName);
                                outputStream.writeUTF(methodName);
                                outputStream.writeObject(paramTypes);
                                outputStream.writeObject(args);
                                outputStream.flush();

                                //4.接收返回的结果
                                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                                Object object = inputStream.readObject();
                                inputStream.close();
                                outputStream.close();

                                socket.close();
                                return object;
                            }
                        });
    }
}
