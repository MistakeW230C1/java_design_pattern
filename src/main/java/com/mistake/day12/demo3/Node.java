package com.mistake.day12.demo3;


abstract class Node {
    protected Node parent = null;

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }

    public Node[] getBrothers() {
        DirectNode parent = (DirectNode) getParent();
        if (parent == null) {
            return null;
        }
        int size = parent.nodeList.size();
        if (size == 1) {
            return null;
        }
        Node nodes[] = new Node[size - 1];
        for (int i = 0; i < size; i++) {
            if (parent.nodeList.get(i) == this) {
                continue;
            }
            nodes[i] = parent.nodeList.get(i);
        }
        return nodes;
    }

    public abstract Node[] getChilds();

    protected String name;

    public Node(String name) {
        this.name = name;
    }

    public void addNode(Node node) throws Exception {
        throw new Exception("Invalid exception");
    }

    abstract void display();
}
