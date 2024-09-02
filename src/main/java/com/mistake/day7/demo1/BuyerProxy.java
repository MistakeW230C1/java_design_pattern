package com.mistake.day7.demo1;

/**
 * @author leoliu
 */
public class BuyerProxy implements ITV {
    private Buyer buyer;

    public BuyerProxy(Buyer buyer) {
        this.buyer = buyer;
    }

    @Override
    public void buyTV() {
        preProcess();
        buyer.buyTV();
        postProcess();
    }

    public void postProcess() {
    }

    public void preProcess() {

    }

}
