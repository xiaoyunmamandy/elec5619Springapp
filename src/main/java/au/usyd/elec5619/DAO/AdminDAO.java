package au.usyd.elec5619.DAO;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import au.usyd.elec5619.domain.Admin;
import au.usyd.elec5619.domain.User;

@Repository
public class AdminDAO {
	@Resource
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public Admin getuserbyname(String adminName) {
		return (Admin) this.getSession().createQuery("from Admin where adminName=?").setString(0, adminName).uniqueResult();
	}
}
