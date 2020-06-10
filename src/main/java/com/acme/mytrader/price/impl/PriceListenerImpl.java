package com.acme.mytrader.price.impl;

import java.util.logging.Logger;

import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.execution.impl.ExecutionServiceImpl;
import com.acme.mytrader.price.PriceListener;

public class PriceListenerImpl implements PriceListener {
	
	Logger log = Logger.getLogger(PriceListenerImpl.class.getSimpleName());
	
	private String security;
	
    ExecutionService executionService = ExecutionServiceImpl.getExecutionService();

	@Override
	public void priceUpdate(String security, double price) {
		this.security = security;
	}

	@Override
	public void run() {
		try { 
			while(true) {
				Thread.sleep(1000);
				if("IBM".equalsIgnoreCase(security)) {
					double ibmStockPrice = executionService.getStockCurrentPrice("IBM");
		            if(ibmStockPrice < 55.0) {
		        		executionService.buy(security, executionService.getStockCurrentPrice("IBM"), 100);
		        		log.info("Bought 100 IBM Stocks");
		            	break;
		            }
				}
				else {
					break;
				}
			}
            
        } catch (InterruptedException e){ 
            Thread.currentThread().interrupt();
            log.severe(e.getMessage());
        }
	}

}
