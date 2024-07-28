package com.mistake.day3.demo7;


public abstract class AbstractFactory {
    private static String Text = "TEXT";

    private static String Image = "IMAGE";

    public abstract IRead create();

    /*static AbstractFactory create(String mark) {
        AbstractFactory abstractFactory = null;
        if (mark.equals(Text)) {
            abstractFactory = new TextFactory();
        }
        if (mark.equals(Image)) {
            abstractFactory = new ImageFactory();
        }
        return abstractFactory;
    }*/
    static AbstractFactory create(String className) {
        AbstractFactory abstractFactory = null;
        try {
            Class c = Class.forName(className);
            abstractFactory = (AbstractFactory) c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return abstractFactory;
    }
}
