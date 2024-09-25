package com.mistake.day12.demo4;

import java.util.Iterator;
import java.util.Set;

public class Dictionary {
    Node root = new MidNode("root");

    public void create() throws Exception {
        String one[] = {"a", "b"};
        String two[][] = {{"a", "ac", "at"}, {"b", "bj", "bt"}};
        String three[][][] = {{{"a", "about"}, {"alike", "amount"}, {"awake", "axis"}},
                {{"baby", "bike"}, {"black", "blind"}, {"burn", "but"}}};
        String china[][][] = {{{"一个", "关于"}, {"像", "数量"}, {"醒", "轴"}},
                {{"婴儿", "自行车"}, {"黑", "瞎"}, {"燃烧", "但是"}}};
        Node parent = null, parent2 = null, child = null;
        for (int i = 0; i < one.length; i++) {
            child = new MidNode(one[i]);
            // 添加第一层子节点
            root.addNode(child);
        }

        for (int i = 0; i < one.length; i++) {
            // 获取到第一层的节点
            parent = ((MidNode) root).get(i);
            for (int j = 0; j < two[i].length; j++) {
                child = new MidNode(two[i][j]);
                // 第一层节点添加第二层节点
                parent.addNode(child);
            }
        }

        for (int i = 0; i < one.length; i++) {
            // 获取到第一层的节点
            parent = ((MidNode) root).get(i);
            for (int j = 0; j < two[i].length; j++) {
                parent2 = ((MidNode) parent).get(j);
                for (int k = 0; k < three[i][j].length; k++) {
                    Word w = new Word(three[i][j][k], china[i][j][k]);
                    WordNode wn = new WordNode(three[i][j][k], w);
                    parent2.addNode(wn);
                }
            }
        }
    }

    void search(String english) {
        Node parent = root;
        Set<Node> s;
        Node cur = null, next = null;
        Iterator<Node> it;
        while (true) {
            s = ((MidNode) parent).nodeSet;
            it = s.iterator();
            // 设置当前节点
            cur = it.next();
            while (it.hasNext()) {
                next = it.next();
                if (english.compareTo(next.key) < 0) {
                    break;
                }
                cur = next;
            }
            s = ((MidNode) cur).nodeSet;
            it = s.iterator();
            if (it.next() instanceof WordNode) {
                break;
            }
            parent = cur;
        }
        s = ((MidNode) cur).nodeSet;
        it = s.iterator();
        Boolean bmark = false;
        while (it.hasNext()) {
            Node tmp = it.next();
            if (tmp.key.equals(english)) {
                System.out.println(english + "----->" + tmp.w.chinese);
                bmark = true;
                break;
            }
        }
        if (bmark == false) {
            System.out.println("没有恰当的翻译");
        }
    }

}
