package com.acme.mytrader.price.impl;

import java.util.concurrent.ExecutorService;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;

import com.acme.mytrader.price.PriceSource;


public class PriceSourceImplTest {
	
	@InjectMocks
	PriceSource priceSource = new PriceSourceImpl();
	
	@Test
	public void testGetExecutorService() {
		ExecutorService executorService = priceSource.getExecutorService();
		Assert.assertNotNull(executorService);
	}
	
	@Test
	public void testAddListener() {
		priceSource.addPriceListener(new PriceListenerImpl());
	}
	
	@Test
	public void testRemovePriceListener() {
		priceSource.removePriceListener(new PriceListenerImpl());
	}

}
