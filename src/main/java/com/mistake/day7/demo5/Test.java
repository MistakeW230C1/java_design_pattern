package com.mistake.day7.demo5;

public class Test {
    public static void main(String[] args) throws Exception {
        Borrow br = new Borrow();
        BorrowProxy bp = new BorrowProxy(br);

        Book book = new Book("1000", "计算机应用");
        br.setBook(book);
        bp.borrow();

        book = new Book("1001", "计算机应用2");
        br.setBook(book);
        bp.borrow();

        bp.log();

    }
}
