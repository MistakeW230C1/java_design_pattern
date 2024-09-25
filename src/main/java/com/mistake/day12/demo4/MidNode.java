package com.mistake.day12.demo4;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class MidNode extends Node {

    Set<Node> nodeSet = new TreeSet<>(new Comparator<Object>() {
        public int compare(Object obj, Object obj2) {
            Node one = (Node) obj;
            Node two = (Node) obj2;
            return one.key.compareTo(two.key);
        }
    });

    public MidNode(String key) {
        // word对象设置为null
        super(key, null);
    }

    /**
     * @param pos
     * @return
     */
    public Node get(int pos) {
        Node node = null;
        Iterator<Node> it = nodeSet.iterator();
        for (int i = 0; i <= pos; i++) {
            node = it.next();
        }
        return node;
    }

    public void addNode(Node node) {
        nodeSet.add(node);
        node.setParent(this);
    }
}
