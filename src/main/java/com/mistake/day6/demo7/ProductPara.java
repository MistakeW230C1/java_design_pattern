package com.mistake.day6.demo7;

/**
 * 员工具体参数定义
 */
public class ProductPara implements IPara {
    @Override
    public String[] getTitle() {
        return new String[]{"编号", "产品名称", "1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"};
    }

    @Override
    public String getPerSql() {
        return "select * from product where prno =";
    }
}
