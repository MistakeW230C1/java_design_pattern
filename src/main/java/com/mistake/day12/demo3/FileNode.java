package com.mistake.day12.demo3;

public class FileNode extends Node {

    @Override
    public Node[] getChilds() {
        return null;
    }

    public FileNode(String name) {
        super(name);
    }

    @Override
    void display() {
        System.out.println(name);
    }

}
