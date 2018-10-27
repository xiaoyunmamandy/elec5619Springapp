package au.usyd.elec5619.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import au.usyd.elec5619.domain.Order;

@Repository
public class OrderDAO {
	
	@Resource
	private SessionFactory sessionFactory;
	//Session session=sessionFactory.openSession();
	private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
	
	public List<Order> getallOrders() {
		List<Order> orders = this.sessionFactory.getCurrentSession().createQuery("FROM Order").list();
		return this.sessionFactory.getCurrentSession().createQuery("FROM Order").list();
	}
	
	public void addOrder(Order order) {
		this.sessionFactory.getCurrentSession().save(order);
	}
	
	public Order getOrderById(long id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Order order = (Order) currentSession.get(Order.class, id);
		return order;
	}
	
	public void deleteOrder(long id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Order order = (Order) currentSession.get(Order.class, id);
		currentSession.delete(order);
	}
}