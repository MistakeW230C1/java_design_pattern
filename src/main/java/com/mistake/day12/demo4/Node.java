package com.mistake.day12.demo4;

abstract class Node {
    /**
     * 节点关键之ø
     */
    String key;

    Word w = null;

    /**
     * 父节点
     */
    Node parent = null;

    public Node(String key, Word w) {
        this.key = key;
        this.w = w;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void addNode(Node node) throws Exception {
        throw new Exception("Invalid exception");
    }
}
