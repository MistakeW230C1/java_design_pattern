package com.mistake.day12.demo5;

public class Test {
    public static void main(String[] args) throws Exception {
        XMLManage obj = new XMLManage();
        obj.create("src/main/resources/day12.demo5/config.xml");
        System.out.println(obj.getValue("root/a2"));
        System.out.println(obj.getValue("root/a/b", "b1"));
        System.out.println(obj.getValue("root/a/b", "b2"));
        System.out.println(obj.getProperty("root/a", "prop1"));
    }
}
