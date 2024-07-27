package com.mistake.day2.demo1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class InvokeUtil {
    Boolean Process(String className, String funcName, Object[] para) throws Exception {
        // 获取类信息对象
        Class classType = Class.forName(className);
        // 形成函数参数序列
        Class c[] = new Class[para.length];
        for (int i = 0; i < para.length; i++) {
            c[i] = para[i].getClass();

        }
        // 调用无参构造函数
        Constructor constructor = classType.getConstructor();
        Object object = constructor.newInstance();
        // 获得函数方法信息
        Method mt = classType.getMethod(funcName, c);
        // 执行该方法
        mt.invoke(object, para);
        return true;
    }
}
