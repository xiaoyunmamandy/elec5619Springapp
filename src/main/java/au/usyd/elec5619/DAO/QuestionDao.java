package au.usyd.elec5619.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import au.usyd.elec5619.domain.Questions;

@Repository
public class QuestionDao {
	@Resource
	private SessionFactory sessionFactory;
//	Session session=sessionFactory.openSession();
	private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
	
	public void addQuestion(Questions question) {
		this.getSession().save(question);
	}
	
	public List<Questions> getallquestions() {
		return this.sessionFactory.getCurrentSession().createQuery("FROM Questions").list();
	}
	
	public Questions getquestionbyID(int id) {
		Query query = getSession().createQuery("from Questions where questionID=?").setInteger(0, id);
		 List<Questions> list = query.list();
		 System.out.println(list);
		 return (Questions) this.getSession().createQuery("from Questions where questionID=?").setInteger(0, id).uniqueResult();
	}
	
	public List<Questions> getquestionbyuser(int userID){
		return this.getSession().createQuery("from Questions where userID=?").setInteger(0, userID).list();
	}
	
}
