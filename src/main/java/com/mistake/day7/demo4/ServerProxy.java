package com.mistake.day7.demo4;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerProxy extends Thread {
    ServerCalc obj;

    public ServerProxy(ServerCalc obj) {
        this.obj = obj;
    }

    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(4000);
            Socket socket = serverSocket.accept();
            while (socket != null) {
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                String method = (String) objectInputStream.readObject();
                if ("calc".equals(method)) {
                    String para = (String) objectInputStream.readObject();
                    float f = obj.calc(para);
                    objectOutputStream.writeObject(f);
                    objectOutputStream.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
