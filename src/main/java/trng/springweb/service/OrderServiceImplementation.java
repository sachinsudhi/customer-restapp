package trng.springweb.service;

import trng.springweb.model.Orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trng.springweb.repository.OrderDao;

@Service
public class OrderServiceImplementation implements OrderService{
	@Autowired
	OrderDao odao;
	public OrderServiceImplementation() {
		//odao=new OrderDaoImplementation();
	}
	@Override
	public boolean createOrder(Orders order) {
		return odao.createOrder(order);
	}

	@Override
	public boolean deleteOrder(Long orderId) {
		return odao.deleteOrder(orderId);
	}

	@Override
	public boolean updateOrder(Orders order) {
		return odao.updateOrder(order);
	}

	@Override
	public Orders getOrder(Orders order) {
		return odao.getOrder(order);
	}
	
}