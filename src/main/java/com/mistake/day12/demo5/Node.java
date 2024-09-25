package com.mistake.day12.demo5;

import java.util.Map;

abstract class Node {
    /**
     * 中间节点起点标识
     */
    public static final int START_NODE = 0;

    /**
     * 中间节点终点标识
     */
    public static final int END_NODE = 1;

    /**
     * 叶节点标识
     */
    public static final int LEAF_NODE = 2;

    /**
     * 名称
     */
    protected String name;

    /**
     * 属性集合
     */
    protected Map<String, String> propMap;

    /**
     * 值
     */
    protected String value;

    /**
     * 判断节点类型
     *
     * @param s s
     * @return int
     */
    public static int getNodeType(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                num++;
            }
        }
        if (num == 1) {
            if (s.charAt(1) == '/') {
                return END_NODE;
            } else {
                return START_NODE;
            }
        }
        return LEAF_NODE;
    }

    public void addNode(Node node) throws Exception {
        throw new Exception("Invalid operation");
    }

    /**
     * 显示
     */
    public abstract void display();
}
