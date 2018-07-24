package trng.springweb.service;

import trng.springweb.model.Orders;

public interface OrderService {
	boolean createOrder(Orders order);

	boolean deleteOrder(Long orderId);

	boolean updateOrder(Orders order);

	Orders getOrder(Orders order);
}
