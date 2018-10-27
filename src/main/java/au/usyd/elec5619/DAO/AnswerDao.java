package au.usyd.elec5619.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import au.usyd.elec5619.domain.Answers;
import au.usyd.elec5619.domain.Questions;

@Repository
public class AnswerDao {
	@Resource
	private SessionFactory sessionFactory;
//	Session session=sessionFactory.openSession();
	private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
	
	public void addAnswer(Answers answer) {
		this.getSession().save(answer);
	}
	
	public List<Answers> getanswerbyID(int id) {
		return this.getSession().createQuery("from Answers where questionID=?").setInteger(0, id).list();
	}
	
	public Answers getanswerbyId(int id) {
		Query query = getSession().createQuery("from Answers where answerID=?").setInteger(0, id);
		 List<Answers> list = query.list();
		 return (Answers) this.getSession().createQuery("from Answers where answerID=?").setInteger(0, id).uniqueResult();
	}
	
	public void updateAnswer(Answers answer) {
		this.getSession().update(answer);
	}
	
}
