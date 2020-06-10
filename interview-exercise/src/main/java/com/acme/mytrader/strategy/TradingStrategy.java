package com.acme.mytrader.strategy;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.execution.impl.ExecutionServiceImpl;
import com.acme.mytrader.price.PriceListener;
import com.acme.mytrader.price.PriceSource;
import com.acme.mytrader.price.impl.PriceListenerImpl;
import com.acme.mytrader.price.impl.PriceSourceImpl;

/**
 * <pre>
 * User Story: As a trader I want to be able to monitor stock prices such
 * that when they breach a trigger level orders can be executed automatically
 * </pre>
 */
public class TradingStrategy {
	
	Logger log = Logger.getLogger(TradingStrategy.class.getSimpleName());
	
	PriceSource priceSource = new PriceSourceImpl();
	
	ExecutionService executionService = ExecutionServiceImpl.getExecutionService();
	
	public static void main(String args[]) throws InterruptedException {
		TradingStrategy tradeStrategy = new TradingStrategy();
		tradeStrategy.buyStocks("IBM", 300);
		tradeStrategy.buyStocks("AXIS", 300);
		tradeStrategy.buyStocks("HDFC", 300);
		tradeStrategy.buyStocks("AXIS", 500);
		tradeStrategy.addPriceListener("IBM");
		tradeStrategy.buyStocks("IBM", 500);
		tradeStrategy.priceSource.getExecutorService().awaitTermination(10, TimeUnit.SECONDS);
	}
	
	public void addPriceListener(String security) {
		PriceListener priceListener = new PriceListenerImpl();
		priceListener.priceUpdate(security, 0);
		log.info("Added new Listener for the Stock:"+security);
		priceSource.addPriceListener(priceListener);
	}
	
	public void buyStocks(String security, int numberOfStocks) {
		executionService.buy(security, executionService.getStockCurrentPrice(security), numberOfStocks);
	}
	
	public void sellStocks(String security, int numberOfStocks) {
		executionService.buy(security, executionService.getStockCurrentPrice(security), numberOfStocks);
	}
}
