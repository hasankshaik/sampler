package com.hasan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	
	@Autowired
	private PriceService priceService;
	
	@Autowired
	private OrderDao orderDao;

	@Autowired
	private DeliveryService deliveryService;
	
	public int getOrderPrice(int orderId){
		Order order = orderDao.getOrder(orderId);
		deliveryService.calculateDelivery();
		return priceService.calculatePriceForOrder(order);
	}
}
