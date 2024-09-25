package com.mistake.day12.demo5;

import java.util.ArrayList;
import java.util.HashMap;

public class MidNode extends Node {

    ArrayList<Node> nodeList = new ArrayList<>();

    public MidNode(String s) {
        String mid = s.substring(1, s.length() - 1);
        String mid2[] = mid.split(" ");
        name = mid2[0];
        if (mid2.length >= 2) {
            propMap = new HashMap<>();
        }
        for (int i = 1; i < mid2.length; i++) {
            String mid3[] = mid2[i].split("=");
            propMap.put(mid3[0], mid3[1]);
        }
        this.nodeList = nodeList;
    }

    public void addNode(Node node) {
        nodeList.add(node);
    }

    @Override
    public void display() {
        System.out.println(name);
        for (int i = 0; i < nodeList.size(); i++) {
            nodeList.get(i).display();
        }
    }
}
