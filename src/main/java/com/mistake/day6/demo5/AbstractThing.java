package com.mistake.day6.demo5;


/**
 * 抽象事物
 */
public class AbstractThing {
    private IPost obj;

    public void createPost(String funcName) throws Exception {
        // 利用反射机制加载功能类对象
        obj = (IPost) Class.forName(funcName).newInstance();
    }

    /**
     * 抽象事物
     */
    public void post() {
        obj.post();
    }


}
