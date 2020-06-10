package com.acme.mytrader.execution.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.model.Stock;

public class ExecutionServiceImpl implements ExecutionService {
	Map<String, com.acme.mytrader.model.Stock> stocks = new ConcurrentHashMap<>();
	private static ExecutionService executionService;
	
	private ExecutionServiceImpl() {
		Stock ibmStock = new Stock();
		ibmStock.setName("IBM");
		ibmStock.setCurrentValue(121.0);
		stocks.put(ibmStock.getName(), ibmStock);
		
		Stock axisStock = new Stock();
		axisStock.setName("AXIS");
		axisStock.setCurrentValue(151.0);
		stocks.put(axisStock.getName(), axisStock);
		
		
		Stock hdfcStock = new Stock();
		hdfcStock.setName("HDFC");
		hdfcStock.setCurrentValue(98.0);
		stocks.put(hdfcStock.getName(), hdfcStock);
	}

	@Override
	public void buy(String security, double price, int volume) {
		Stock stock = stocks.get(security);
		stock.setCurrentValue(stock.getCurrentValue()-(volume*0.1));
		stocks.put(security, stock);
		
	}

	@Override
	public void sell(String security, double price, int volume) {
		Stock stock = stocks.get(security);
		stock.setCurrentValue(stock.getCurrentValue()+(volume*0.1));
		stocks.put(security, stock);
	}

	
	public double getStockCurrentPrice(String security) {
		return stocks.get(security).getCurrentValue();
	}
	
	public static ExecutionService getExecutionService() {
		if(null == executionService) {
			executionService = new ExecutionServiceImpl();
		}
		return executionService;
	}
}
