package com.acme.mytrader.price;

public interface PriceListener extends Runnable{
    void priceUpdate(String security, double price);
}
