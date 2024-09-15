package com.mistake.day9.demo4;


public abstract class Sheet {
    /**
     * 账号
     */
    String account;

    /**
     * 姓名
     */
    String name;

    /**
     * 余额
     */
    float money;

    /**
     * 存款日期
     */
    String startDate;

    /**
     * 期限
     */
    int range;

    public Sheet(String account, String name, float money, String startDate, int range) {
        this.account = account;
        this.name = name;
        this.money = money;
        this.startDate = startDate;
        this.range = range;
    }

    public void accept(IVisitor<Sheet> v) {
        v.visit(this);
    }
}
