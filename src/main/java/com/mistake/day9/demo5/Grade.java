package com.mistake.day9.demo5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Grade {
    Map<String, BanJi> map = new HashMap<>();

    public BanJi add(String banji) {
        BanJi obj = new BanJi();
        map.put(banji, obj);
        return obj;
    }

    public void readFile(String strFile) {
        String s = "";
        BanJi obj = null;
        try {
            FileReader in = new FileReader(strFile);
            BufferedReader in2 = new BufferedReader(in);
            while ((s = in2.readLine()) != null) {
                s = s.trim();
                if (s.equals("")) {
                    continue;
                }
                if (s.startsWith("班级")) {
                    obj = add(s);
                    continue;
                }
                String t[] = s.split(" ");
                Student student = new Student(t);
                obj.add(student);
            }
            in2.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
