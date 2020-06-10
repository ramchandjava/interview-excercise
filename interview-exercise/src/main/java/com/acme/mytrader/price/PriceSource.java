package com.acme.mytrader.price;

import java.util.concurrent.ExecutorService;

public interface PriceSource {
    void addPriceListener(PriceListener listener);
    void removePriceListener(PriceListener listener);
    public ExecutorService getExecutorService();
}
