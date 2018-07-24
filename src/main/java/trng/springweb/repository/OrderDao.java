package trng.springweb.repository;

import trng.springweb.model.Orders;

public interface OrderDao {
	boolean createOrder(Orders order);

	boolean deleteOrder(Long orderId);

	boolean updateOrder(Orders order);

	Orders getOrder(Orders order);
}
