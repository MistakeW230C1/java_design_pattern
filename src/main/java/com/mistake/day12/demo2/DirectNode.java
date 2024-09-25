package com.mistake.day12.demo2;

import java.util.ArrayList;

public class DirectNode extends Node {
    ArrayList<Node> nodeList = new ArrayList<>();

    public DirectNode(String name) {
        super(name);
    }

    public void addNode(Node node) throws Exception {
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
