package com.mistake.day7.demo6;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ServerProxy {
    public static Map<String, Object> map = new HashMap<>();

    public void registry(String key, Object value) {
        map.put(key, value);
    }

    public void process(int socketNO) throws Exception {
        ServerSocket serverSocket = new ServerSocket(socketNO);
        while (true) {
            Socket socket = serverSocket.accept();
            if (socket != null) {
                MySocket ms = new MySocket(socket);
                ms.start();
            }
        }
    }
}
