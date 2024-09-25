package com.mistake.day12.demo2;

public class FileNode extends Node {

    public FileNode(String name) {
        super(name);
    }

    @Override
    void display() {
        System.out.println(name);
    }
}
