package com.mistake.day12.demo1;

import java.io.File;

public class Test {

    public static void createTree(DirectNode node) {
        File f = new File(node.nodeName);
        File f2[] = f.listFiles();

        for (int i = 0; i < f2.length; i++) {
            if (f2[i].isFile()) {
                FileLeaf leaf = new FileLeaf(f2[i].getAbsolutePath());
                node.addLeaf(leaf);
            }
            if (f2[i].isDirectory()) {
                DirectNode node2 = new DirectNode(f2[i].getAbsolutePath());
                node.addNode(node2);
                createTree(node2);
            }
        }
    }

    public static void main(String[] args) {
        DirectNode start = new DirectNode("/Users/mistake/c_copy");
        createTree(start);
        start.display();
    }
}
