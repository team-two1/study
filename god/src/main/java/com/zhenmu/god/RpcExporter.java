//package com.zhenmu.god;
//
//import com.zhenmu.water.service.RPCClientService;
//import com.zhenmu.water.service.impl.RPCClientServiceImpl;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.lang.reflect.Method;
//import java.net.ServerSocket;
//import java.net.Socket;
//
///**
// * @author by xuzhen4.
// * @version: V1.0.
// * @description: .
// * @create: 2019-7-23 9:53
// */
//@Component
//public class RpcExporter {
//
//   // @PostConstruct
//    public void serviceInit(){
//        try {
//            ServerSocket serverSocket=new ServerSocket(8888);
//            System.out.println("启动远程服务监听...");
//            //监听客户端发来消息
//            while (true){
//                Socket socket=serverSocket.accept();
//                ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());
//                //读取客户端传输协议包
//                String className=objectInputStream.readUTF();
//                String methodName=objectInputStream.readUTF();
//                Class<?>[] parameterTypes=(Class<?>[])objectInputStream.readObject();
//                Object[] arguments= (Object[]) objectInputStream.readObject();
//
//                Class clazz=null;
//                //服务注册：API到具体实现的映射
//                if(className.equals(RPCClientService.class.getName())){
//                    clazz= RPCClientServiceImpl.class;
//                }
//                //传入方法名，方法参数类型获得方法对象
//                Method method=clazz.getMethod(methodName,parameterTypes);
//                //传入实现类对象，方法参数数组，方法对象执行获得返回结果对象
//                Object result=method.invoke(clazz.newInstance(),arguments);
//
//                ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
//                objectOutputStream.writeObject(result);
//                objectOutputStream.flush();
//
//                objectInputStream.close();
//                objectOutputStream.close();
//                socket.close();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
