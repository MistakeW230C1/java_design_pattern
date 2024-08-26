package com.mistake.day5.demo6;

import com.mistake.day4.demo1.DbProc;

import java.util.Observable;
import java.util.Observer;

public class DataObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        Subject subject = (Subject) o;
        String strSql = "insert into normal values ("+subject.getData()+",now())";
        DbProc dbProc = new DbProc();
        try{
            dbProc.connect();
            dbProc.executeUpdate(strSql);
            dbProc.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
