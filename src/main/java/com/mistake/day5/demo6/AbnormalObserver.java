package com.mistake.day5.demo6;

import com.mistake.day4.demo1.DbProc;

import java.util.Observable;
import java.util.Observer;

public class AbnormalObserver implements Observer {
    /**
     * 温度异常值累积
     */
    private int c = 0;

    @Override
    public void update(Observable o, Object arg) {
        Subject subject = (Subject) o;
        Factor factor = (Factor) arg;
        if (subject.getData() <factor.getLimit()){
            c = 0;
            return;
        }
        c ++;
        saveToAbnormal(subject);
    }

    private void saveToAbnormal(Subject subject) {
        String strSql = "insert into abnormal values("+ subject.getData()+",now())";
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
