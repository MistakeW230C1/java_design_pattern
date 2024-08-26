package com.mistake.day6.demo5;

public class test {
    public static void main(String[] args) throws Exception {
        ThingManger thingManger = new ThingManger();
        AbstractThing thing = thingManger.createThing("com.mistake.day6.demo5.Letter");
        thing.createPost("com.mistake.day6.demo5.SimplePost");
        thing.post();
    }
}
