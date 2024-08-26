package com.mistake.day6.demo5;

public class ThingManger {
    AbstractThing thing;

    AbstractThing createThing(String thingName) throws Exception {
        // 利用反射机制加载事物类对象
        thing = (AbstractThing) Class.forName(thingName).newInstance();
        return thing;
    }
}
