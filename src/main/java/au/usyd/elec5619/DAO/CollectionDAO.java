package au.usyd.elec5619.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import au.usyd.elec5619.domain.Collection;

@Repository
public class CollectionDAO {
	@Resource
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	//添加收藏
	public void addcollection(Collection collection) {
		this.getSession().save(collection);
	}
	//取消收藏
	public void deletecollection(int collectionID) {
		this.getSession().createQuery("delete Collection where id=?").setParameter(0, collectionID).executeUpdate();
	}
	//查找user所有收藏
	public List<Collection> getcollectionbyuser(int userID) {
		return this.getSession().createQuery("from Collection where userID=?").setInteger(0, userID).list();
	}
	public Collection getcollection(int userID,int recipeID) {
		return (Collection) this.getSession().createQuery("from Collection where (userID=? and recipeID=?)").setInteger(0, userID).setInteger(1, recipeID).uniqueResult();
	}
	

}
