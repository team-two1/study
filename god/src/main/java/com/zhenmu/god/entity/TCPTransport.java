package com.zhenmu.god.entity;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author by xuzhen4.
 * @version: V1.0.
 * @description: .
 * @create: 2019-8-16 16:07
 */
public class TCPTransport {

    public String host;

    public Integer port;

    public TCPTransport(String host, Integer port) {
        this.host = host;
        this.port = port;
    }
    private Socket newSocket(){
        try {
            return new Socket(host,port);
        } catch (IOException e) {
            throw new RuntimeException("连接建立失败");
        }
    }

    public Object send(RpcRequest rpcRequest){
        Socket socket = newSocket();
        //发送请求到服务端
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(rpcRequest);
            objectOutputStream.flush();
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object result = objectInputStream.readObject();
            objectInputStream.close();
            objectOutputStream.close();
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("发起远程调用异常",e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
