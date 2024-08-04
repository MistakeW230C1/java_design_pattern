package com.mistake.day4.demo2;

public class Director {
    public IWebBuilder build;

    public Director(IWebBuilder builder) {
        this.build = builder;
    }

    public String build(String accountNo) {
        build.getData(accountNo);
        return build.getUI();
    }
}
