package com.mistake.day8.demo2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mistake
 */
public class Manage {
    private Map<String, CellContext> map = new HashMap<>();

    public boolean regist(CellContext ct) {
        map.put(ct.strPhone, ct);
        return true;
    }

    /**
     * 为源手机号存入钱
     *
     * @param strPhoneNO
     * @param money
     */
    public void save(String strPhoneNO, float money) {
        CellContext ct = map.get(strPhoneNO);
        ct.save(money);
    }

    /**
     * 为源手机号存入钱
     *
     * @param strPhoneNO
     * @param money
     */
    public Boolean phone(String strPhoneNO) {
        CellContext ct = map.get(strPhoneNO);
        ct.call();
        return true;
    }
}
