package com.mistake.day12.demo5;

import java.util.HashMap;

public class LeafNode extends Node {

    /**
     * s 形如<b name = b2>bvalue2</b>
     *
     * @param s
     */
    public LeafNode(String s) {
        int start = 1;
        int end = s.indexOf('>');
        // 拆分结果为[b name =b2]
        String mid = s.substring(start, end);
        String mid2[] = mid.split(" ");
        name = mid2[0];
        if (mid2.length >= 2) {
            propMap = new HashMap<>();
        }
        for (int i = 1; i < mid2.length; i++) {
            String mid3[] = mid2[i].split("=");
            propMap.put(mid3[0], mid3[1]);
        }
        start = end + 1;
        end = s.indexOf('<', start);
        value = s.substring(start, end);
    }

    @Override
    public void display() {
        System.out.println(name);
    }
}
