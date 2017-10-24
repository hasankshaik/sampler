package com.hasan;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DeliveryServiceTest {

	@InjectMocks
	private DeliveryService deliveryService;

	@Spy
	private Availability availability;

	@Before
	public void setUp(){
	}
	
	@Test
	public void testGetOrderService(){

		Mockito.doReturn("OtherName").when(availability).getName();
		Assert.assertEquals(deliveryService.calculateDelivery(), 10);
	}
}
