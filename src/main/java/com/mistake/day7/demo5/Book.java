package com.mistake.day7.demo5;

public class Book {
    /**
     * 书号
     */
    private String no;

    /**
     * 书名
     */
    private String name;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book(String no, String name) {
        this.no = no;
        this.name = name;
    }

}
