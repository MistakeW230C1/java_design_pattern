package com.mistake.day11.demo6;

interface IEntry {

    /**
     * 当前游标位置
     *
     * @return int
     */
    int getCursor();

    /**
     * 总记录数目
     *
     * @return int
     */
    int getTotal();

    /**
     * 总记录数目
     */
    void entry(String strFile) throws Exception;
}
