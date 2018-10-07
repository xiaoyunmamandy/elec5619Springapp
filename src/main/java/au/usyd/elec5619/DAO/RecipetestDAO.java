package au.usyd.elec5619.DAO;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import au.usyd.elec5619.domain.Recipetest;

@Repository
public class RecipetestDAO {
	@Resource
	private SessionFactory sessionFactory;
	private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
	
	public void addnewrecipe(Recipetest recipetest) {
		this.getSession().save(recipetest);
	}
}
