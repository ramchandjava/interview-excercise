package com.acme.mytrader.price.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.acme.mytrader.price.PriceListener;
import com.acme.mytrader.price.PriceSource;

public class PriceSourceImpl implements PriceSource {
	private ExecutorService executorService = Executors.newFixedThreadPool(10);
	@Override
	public void addPriceListener(PriceListener listener) {
		executorService.execute(listener);
	}
	
	@Override
	public void removePriceListener(PriceListener listener) {
		
	}

	@Override
	public ExecutorService getExecutorService() {
		return executorService;
	}

}
