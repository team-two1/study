package com.zhenmu.god;


import org.springframework.stereotype.Component;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author by xuzhen4.
 * @version: V1.0.
 * @description: .
 * @create: 2019-8-16 16:09
 */
@Component
public class Provider {
/*
    public static void regist(){
        ExecutorService executor = Executors.newCachedThreadPool();

        executor.submit(() -> { //Lambda 是一个 callable， 提交后便立即执行，这里返回的是 FutureTask 实例
            try {
                provider();
            } catch (Exception e){
                e.printStackTrace();
            } catch (Throwable t){
                t.printStackTrace();
            }
        });
    }*/

//    @PostConstruct
   /* public static void provider() throws Throwable{
        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;
        ServerSocket serverSocket = null;
        try {
            //1.Socket绑定本地端口
            serverSocket = new ServerSocket(8050);
            //2.监听端口
            while (true){
                System.out.println("开启端口监听");
                Socket socket = serverSocket.accept();
                //1.接收所有的参数
                inputStream = new ObjectInputStream(socket.getInputStream());
                String apiClassName = inputStream.readUTF();
                String methodName = inputStream.readUTF();
                Class[] paramTypes = (Class[]) inputStream.readObject();
                Object[] args4Method = (Object[]) inputStream.readObject();
                Class clazz = null;
                //2.服务注册，找到具体的实现类
                if (apiClassName.equals(RPCClientService.class.getName())){
                    clazz = RPCClientServiceImpl.class;
                }
                //3.执行UserServiceImpl的方法
                Method method = clazz.getMethod(methodName,paramTypes);
                Object invoke = method.invoke(clazz.newInstance(),args4Method);

                //4.返回结果给客户端
                outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject(invoke);
                outputStream.flush();
            }

        }catch (Exception e){
            e.printStackTrace();
            throw e;
        } finally {
            if (outputStream != null) outputStream.close();
            if (inputStream != null) inputStream.close();
            if (serverSocket != null) serverSocket.close();
        }
    }*/
}
