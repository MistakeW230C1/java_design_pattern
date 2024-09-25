package com.mistake.day12.demo2;

abstract class Node {
    protected String name;

    public Node(String name) {
        this.name = name;
    }

    public void addNode(Node node) throws Exception {
        throw new Exception("Invalid exception");
    }

    abstract void display();
}
