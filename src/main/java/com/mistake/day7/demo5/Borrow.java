package com.mistake.day7.demo5;

public class Borrow implements IBorrow{
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean borrow() {
        return true;
    }
}
