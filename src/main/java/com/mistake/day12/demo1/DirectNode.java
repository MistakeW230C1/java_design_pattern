package com.mistake.day12.demo1;

import java.util.ArrayList;

public class DirectNode {
    String nodeName;

    public DirectNode(String nodeName) {
        this.nodeName = nodeName;
    }

    ArrayList<DirectNode> nodeList = new ArrayList<>();
    ArrayList<FileLeaf> leftList = new ArrayList<>();

    /**
     * 添加下一级目录
     *
     * @param node node
     */
    public void addNode(DirectNode node) {
        nodeList.add(node);
    }

    /**
     * 添加本级文件
     *
     * @param leaf leaf
     */
    public void addLeaf(FileLeaf leaf) {
        leftList.add(leaf);
    }

    public void display() {
        for (int i = 0; i < leftList.size(); i++) {
            leftList.get(i).display();
        }

        for (int i = 0; i < nodeList.size(); i++) {
            System.out.println(nodeList.get(i).nodeName);
            nodeList.get(i).display();
        }
    }
}
