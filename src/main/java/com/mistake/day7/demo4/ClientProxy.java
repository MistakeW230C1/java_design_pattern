package com.mistake.day7.demo4;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientProxy implements ICalc {
    Socket socket;

    public ClientProxy() throws Exception {
        socket = new Socket("localhost", 4000);
    }

    @Override
    public float calc(String expression) throws Exception {
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        out.writeObject("calc");
        out.writeObject(expression);
        Float value = in.readFloat();
        return value;
    }
}
