package au.usyd.elec5619.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import au.usyd.elec5619.domain.Product;

@Repository
public class ProductDAO {
	
	@Resource
	private SessionFactory sessionFactory;
	//Session session=sessionFactory.openSession();
	private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
	
	public void increasePrice(int percentage) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		List<Product> products = currentSession.createQuery("FROM Product").list();
		if (products != null) {
			for (Product product : products) {
				double newPrice = product.getPrice().doubleValue() * (100 + percentage)/100;
				product.setPrice(newPrice);
				currentSession.save(product);
			}
		}
	}
	
	public List<Product> getallProducts() {
		List<Product> products = this.sessionFactory.getCurrentSession().createQuery("FROM Product").list();
		return this.sessionFactory.getCurrentSession().createQuery("FROM Product").list();
	}
	
	public void addProduct(Product product) {
		this.sessionFactory.getCurrentSession().save(product);
	}
	
	public Product getProductById(long id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Product product = (Product) currentSession.get(Product.class, id);
		return product;
	}
	
	public void updateProduct(Product product) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.merge(product);
	}
	
	public void deleteProduct(long id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Product product = (Product) currentSession.get(Product.class, id);
		currentSession.delete(product);
	}
}
