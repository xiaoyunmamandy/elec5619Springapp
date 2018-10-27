package au.usyd.elec5619.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import au.usyd.elec5619.domain.Comment;
import au.usyd.elec5619.domain.Recipe;


@Repository
public class CommentDAO{
	@Resource
	private SessionFactory sessionFactory;
	private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
	
	public void addComment(Comment comment) {
		this.getSession().save(comment);
	}
	public void deleteComment(int commentID) {
		this.getSession().createQuery("delete Comment where id=?").setParameter(0, commentID).executeUpdate();
	}
	
	public List<Comment> getcommentbyID(int id) {
		return this.getSession().createQuery("from Comment where recipeID=?").setInteger(0, id).list();
	}
	
	public Comment getcommentbyId(int id) {
		Query query = getSession().createQuery("from Comment where commentID=?").setInteger(0, id);
		 List<Comment> list = query.list();
		 return (Comment) this.getSession().createQuery("from Comment where commentID=?").setInteger(0, id).uniqueResult();
	}
	
	public void updateComment(Comment comment) {
		this.getSession().update(comment);
	}
	
	public List<Comment> getcommentbyuser(int userID){
		return this.getSession().createQuery("from Comment where userID=?").setInteger(0, userID).list();
	}
	
}