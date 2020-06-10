package ccom.acme.mytrader.execution.impl;

import org.junit.Test;
import org.mockito.InjectMocks;

import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.execution.impl.ExecutionServiceImpl;


public class ExecutionServicemplTest {
	
	@InjectMocks
	ExecutionService executionService = ExecutionServiceImpl.getExecutionService();
	
	@Test
	public void testBuy() {
		executionService.buy("IBM", 1000.0, 100);
		
	}
	
	@Test
	public void testSell() {
		executionService.sell("IBM", 1000.0, 100);
		
	}

}
