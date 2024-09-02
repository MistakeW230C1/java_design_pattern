package com.mistake.day7.demo2;

public class ProxyItem implements IItem {
    private RealItem realItem;

    /**
     * 表示content,plan是否填充
     */
    Boolean bFill;

    public ProxyItem(RealItem realItem) {
        this.realItem = realItem;
    }

    @Override
    public String getAccount() {
        return realItem.getContent();
    }

    @Override
    public void setAccount(String s) {
        realItem.setAccount(s);
    }

    @Override
    public String getName() {
        return realItem.getName();
    }

    @Override
    public void setName(String s) {
        realItem.setName(s);
    }

    @Override
    public String getProject() {
        return realItem.getProject();
    }

    @Override
    public void setProject(String s) {
        realItem.setProject(s);
    }

    @Override
    public String getContent() {
        return realItem.getContent();
    }

    @Override
    public String getPlan() {
        return realItem.getPlan();
    }

    @Override
    public void itemFill() throws Exception {
        if (!bFill){
            realItem.itemFill();
            bFill = true;
        }
    }
}
