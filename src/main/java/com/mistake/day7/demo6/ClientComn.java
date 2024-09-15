package com.mistake.day7.demo6;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientComn {
    Socket socket;

    public ClientComn(String IP, int socketNO) throws Exception {
        socket = new Socket(IP, socketNO);
    }

    Object invoke(String regionName, String methodName, Object[] para) throws Exception {
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        out.writeObject(regionName);
        out.writeObject(methodName);
        out.writeObject(para);
        return in.readObject();
    }
}
