package au.usyd.elec5619.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import au.usyd.elec5619.DAO.OrderDAO;
import au.usyd.elec5619.domain.Order;
//使用注解就可以不用在XML中再写其他的
@Service(value="ordermanager")
@Transactional
public class OrderManagerImpl implements OrderManager {
	
	@Autowired
	public OrderDAO orderDAO;
	
	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return orderDAO.getallOrders();
	}

	@Override
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		orderDAO.addOrder(order);
	}

	@Override
	public Order getOrderById(long id) {
		// TODO Auto-generated method stub
		return orderDAO.getOrderById(id);
	}
	
	@Override
	public void deleteOrder(long id) {
		// TODO Auto-generated method stub
		orderDAO.deleteOrder(id);
	}
	
}