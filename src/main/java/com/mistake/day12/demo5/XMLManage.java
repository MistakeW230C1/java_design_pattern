package com.mistake.day12.demo5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

public class XMLManage {
    Node root;

    /**
     * 根据xml 文件创建树
     *
     * @param strFile strFile
     * @return boolean
     * @throws Exception
     */
    public boolean create(String strFile) throws Exception {
        FileReader in = new FileReader(strFile);
        BufferedReader in2 = new BufferedReader(in);
        String s = in2.readLine();
        s = s.trim();
        root = new MidNode(s);
        Stack<Node> st = new Stack<>();
        st.push(root);
        while ((s = in2.readLine()) != null) {
            s = s.trim();
            if (s.equals("")) {
                continue;
            }
            int mark = Node.getNodeType(s);
            if (mark == Node.START_NODE) {
                Node node = new MidNode(s);
                Node top = st.peek();
                top.addNode(node);
                st.push(node);
            } else if (mark == Node.END_NODE) {
                st.pop();
            } else {
                Node node = new LeafNode(s);
                Node top = st.peek();
                top.addNode(node);
            }
        }
        in2.close();
        in.close();
        return true;
    }

    Node getLayer(String s[]) {
        Node result = root;
        try {
            if (!root.name.equals(s[0])) {
                return null;
            }
            ArrayList<Node> mid = ((MidNode) root).nodeList;
            int i, j;
            for (i = 0; i < s.length - 1; i++) {
                boolean bmark = false;
                for (j = 0; j < mid.size(); j++) {
                    String name = mid.get(j).name;
                    if (name.equals(s[i])) {
                        bmark = true;
                        break;
                    }
                    if (!bmark) {
                        return null;
                    }
                    result = mid.get(j);
                    mid = ((MidNode) result).nodeList;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 确定该路径节点对应的值
     *
     * @param strPath strPath
     * @return String
     */
    String getValue(String strPath) {
        String s[] = strPath.split("/");
        Node result = getLayer(s);
        if (result == null) {
            return null;
        }
        Boolean bmark = false;
        ArrayList<Node> mid = ((MidNode) result).nodeList;
        for (int i = 0; i < mid.size(); i++) {
            result = mid.get(i);
            // 若路径匹配
            if (result.name.equals(s[s.length - 1])) {
                bmark = true;
                break;
            }


        }
        if (bmark) {
            return result.value;
        }
        return null;
    }

    /**
     * 确定该路径节点对应的值
     *
     * @param strPath      strPath
     * @param strPropValue strPropValue
     * @return String
     */
    String getValue(String strPath, String strPropValue) {
        String s[] = strPath.split("/");
        Node result = getLayer(s);
        if (result == null) {
            return null;
        }
        boolean bmark = false;
        ArrayList<Node> mid = ((MidNode) result).nodeList;
        for (int i = 0; i < mid.size(); i++) {
            result = mid.get(i);
            // 如果路径匹配
            if (result.name.equals(s[s.length - 1])) {
                bmark = true;
                break;
            }
        }
        if (bmark) {
            return result.value;
        }
        return null;
    }

    /**
     * 确定该路径节点对应的属性值
     *
     * @param strPath      strPath
     * @param strPropValue strPropValue
     * @return String
     */
    String getProperty(String strPath, String strPropValue) {
        String s[] = strPath.split("/");
        Node result = getLayer(s);
        if (result == null) {
            return null;
        }
        boolean bmark = false;
        ArrayList<Node> mid = ((MidNode) result).nodeList;
        for (int i = 0; i < mid.size(); i++) {
            result = mid.get(i);
            if (result.name.equals(s[s.length - 1])) {
                bmark = true;
                break;
            }
        }
        if (bmark) {
            Map<String, String> map = result.propMap;
            return map.get(strPropValue);
        }
        return null;
    }
}
