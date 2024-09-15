package com.mistake.day7.demo6;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

public class MySocket extends Thread {
    Socket socket;

    public MySocket(Socket socket) {
        this.socket = socket;
    }

    public Object invoke(String registName, String methodName, Object para[]) throws Exception {
        // 获取注册对象
        Object obj = ServerProxy.map.get(registName);
        // 形成函数参数序列
        Class classType = Class.forName(obj.getClass().getName());
        Class c[] = new Class[para.length];
        for (int i = 0; i < para.length; i++) {
            c[i] = para[i].getClass();
        }
        // 利用反射机制调用主题对象方法
        Method mt = classType.getMethod(methodName, c);
        return mt.invoke(obj, para);
    }

    @Override
    public void run() {
        while (true) {
            try {
                InputStream inputStream = socket.getInputStream();
                if (inputStream == null || inputStream.available() == 0) {
                    ObjectInputStream in = new ObjectInputStream(inputStream);
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    String registName = (String) in.readObject();
                    String methodName = (String) in.readObject();
                    Object[] para = (Object[]) in.readObject();
                    // 动态调用主题对象
                    Object result = invoke(registName, methodName, para);
                    out.writeObject(result);
                    out.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
