package com.acme.mytrader.execution;

public interface ExecutionService {
    void buy(String security, double price, int volume);
    void sell(String security, double price, int volume);
    double getStockCurrentPrice(String security);
    public static ExecutionService getExecutionService() {
		return null;
	};
}
