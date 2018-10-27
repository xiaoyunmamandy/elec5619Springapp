package au.usyd.elec5619.service;

import java.io.Serializable;
import java.util.List;

import au.usyd.elec5619.domain.Order;

public interface OrderManager extends Serializable{

	public List<Order> getOrders();
	
	public void addOrder(Order order);
	
	public Order getOrderById(long id);
	
	public void deleteOrder(long id);
}