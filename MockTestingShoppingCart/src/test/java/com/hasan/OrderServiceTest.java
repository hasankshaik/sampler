package com.hasan;

import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {
	private static final int TEST_ORDER_ID = 15;
	private static final int TEST_SHOES_PRICE = 2;   
	private static final int TEST_SHIRT_PRICE = 1;

	@InjectMocks
	private OrderService orderService;
	
	@Spy
	private PriceService priceService;

	@Spy
	private DeliveryService deliveryService;

	@Mock
	private OrderDao orderDao;
	


	@Before
	public void setUp(){
	}
	
	@Test
	public void testGetOrderService(){
		Order order = new Order(Arrays.asList(Item.SHOES, Item.SHIRT));
		//Case 1 : Mocking unimplemented method
		Mockito.when(orderDao.getOrder(TEST_ORDER_ID)).thenReturn(order);

		//Case 2 : Using spy we make actual object perform the service

		//Case 3 : Using Spy to call actual object but mocking unimplemented method spy object
		Mockito.doReturn(TEST_SHIRT_PRICE).when(priceService).getActualPrice(Item.SHIRT);
		Mockito.doReturn(TEST_SHOES_PRICE).when(priceService).getActualPrice(Item.SHOES);
		
		//call testing method
		int actualOrderPrice = orderService.getOrderPrice(TEST_ORDER_ID);
		
		Assert.assertEquals(TEST_SHIRT_PRICE + TEST_SHOES_PRICE, actualOrderPrice);
	}
}
