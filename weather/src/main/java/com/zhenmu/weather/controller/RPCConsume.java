package com.zhenmu.weather.controller;

import com.zhenmu.water.entity.User;
import com.zhenmu.water.service.RPCClientService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * @author by xuzhen4.
 * @version: V1.0.
 * @description: RPC框架测试.
 * @create: 2019-7-20 9:55
 */
@RestController
@RequestMapping(value = "weather/rpc")
public class RPCConsume{

    @Reference
    RPCClientService clientService;

    @RequestMapping(value = "/testAlive", method = RequestMethod.GET)
    @ResponseBody
    public void testAlive(){
        try{
//            clientService.rpcTest("dddd");
            System.out.println("I am alive");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/testRPC", method = RequestMethod.GET)
    @ResponseBody
    public User testRPC(@RequestParam("id") Integer id){
        RPCClientService clientService= (RPCClientService) rpc(RPCClientService.class);
        User user=clientService.selectById(id);
        System.out.println(user.toString());
        return user;
    }
//
//    @RequestMapping(value = "/testRPC2", method = RequestMethod.GET)
//    @ResponseBody
//    public String testRPC2(@RequestParam("id") Integer id){
//        RPCClientService clientService= (RPCClientService) rpc(RPCClientService.class);
//        String result=clientService.rpcTest(String.valueOf(id));
//        System.out.println("本地输出远程调用结果：\n"+result);
//        return result;
//    }
//
//    //本地调用远程服务
//    public  static  void  main(String args[]){
//        RPCClientService clientService= (RPCClientService) rpc(RPCClientService.class);
//        User user=clientService.selectById(1);
//        System.out.println("本地输出远程调用结果：\n"+user.toString());
//    }
    /**
     *  动态创建代理对象
     *  Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
     *  参数1：真实对象的类加载器
     *  参数2：真实对象实现的所有的接口,接口是特殊的类，使用Class[]装载多个接口
     *  参数3： 接口，传递一个匿名内部类对象
     * @param clazz
     * @return
     */
    public  static Object rpc(final Class clazz){
        // Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
        return Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz},new InvocationHandler() {
            /*
             * @param proxy  代理对象
             * @param method    代理的方法对象
             * @param args  方法调用时参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                try{
                    Socket socket=new Socket("127.0.0.1",8090);
                    socket.setSoTimeout(1000000);//read的超时时间
                    String className=clazz.getName();//api类名
                    String  methodName=method.getName();//api 类成员方法名
                    Class<?>[] parameterTypes=method.getParameterTypes(); //类成员方法参数类型集合

                    ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
                    objectOutputStream.writeUTF(className);
                    objectOutputStream.writeUTF(methodName);
                    objectOutputStream.writeObject(parameterTypes);
                    objectOutputStream.writeObject(args);

                    ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());
                    Object o=objectInputStream.readObject();
                    objectInputStream.close();
                    objectOutputStream.close();
                    return o;
                }catch (Exception e){
                    e.printStackTrace();
                }
                return null;
            }
        });
    }
}
