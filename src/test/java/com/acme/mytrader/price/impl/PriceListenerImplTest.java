package com.acme.mytrader.price.impl;

import java.util.concurrent.ExecutorService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import com.acme.mytrader.price.PriceListener;
import com.acme.mytrader.price.PriceSource;


public class PriceListenerImplTest {
	
	@InjectMocks
	PriceListener priceListener = new PriceListenerImpl();
	
	@Before
	public void setup() {
		priceListener.priceUpdate("IBM", 0);
		
	}
	
	@Test
	public void testRun() {
		priceListener.run();
	}
	
	@Test
	public void testPriceUpdate() {
		priceListener.priceUpdate("IBM", 0);
	}

}
