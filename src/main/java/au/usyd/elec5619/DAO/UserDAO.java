package au.usyd.elec5619.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import au.usyd.elec5619.domain.User;

@Repository
public class UserDAO {
	@Resource
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	// ×¢²á
	public void addUser(User user) {
		this.getSession().save(user);
	}
	//µÇÂ¼
	public User getuserbyemail(String email) {
		return (User) this.getSession().createQuery("from User where email=?").setString(0, email).uniqueResult();
	}

	public User getUserById(int id) {
		Query query = getSession().createQuery("from User where userID=?").setInteger(0, id);
		return (User) this.getSession().createQuery("from User where id=?").setInteger(0, id).uniqueResult();
	}

	public void updateUser(User user) {
		this.getSession().update(user);
	}

	public void deleteUserById(String id) {
		this.getSession().createQuery("delete User where id=?").setParameter(0, id).executeUpdate();
	}

	public List<User> getallusers() {
		return this.sessionFactory.getCurrentSession().createQuery("FROM User").list();
	}

}
