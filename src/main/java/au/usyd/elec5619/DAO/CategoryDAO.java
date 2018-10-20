package au.usyd.elec5619.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import au.usyd.elec5619.domain.Category;
import au.usyd.elec5619.domain.Recipe;

@Repository
public class CategoryDAO {
	@Resource
	private SessionFactory sessionFactory;
	
	private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
	
	public List<Category> getallcategories(){
		return this.getSession().createCriteria(Category.class).list();
	}
	
	public String getcategorynamebyID(int id) {
		String hql = "select categoryName from Category where categoryID="+id;
		Query query = this.getSession().createQuery(hql);
		List<String> list = query.list();
		String categoryName="";
		for(String str : list){
			categoryName = str;
		}
		//this.getSession().createQuery("select categoryName from Category where categoryID=?").setInteger(0, id).toString();
		return categoryName;
	}

}
