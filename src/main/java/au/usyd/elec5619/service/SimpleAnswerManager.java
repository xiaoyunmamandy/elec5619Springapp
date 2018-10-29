package au.usyd.elec5619.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import au.usyd.elec5619.DAO.AnswerDao;
import au.usyd.elec5619.DAO.QuestionDao;
import au.usyd.elec5619.domain.Answers;
import au.usyd.elec5619.domain.Questions;
import au.usyd.elec5619.domain.SubQA;


@Transactional
@Service(value="addanswers")
public class SimpleAnswerManager implements AnswerManager {
	
	@Autowired
	public AnswerDao answerDao;
	@Autowired
	public QuestionDao questionDao;
	
	
	
	private List<Answers> answers;
    
	public void setAnswerDAO(AnswerDao answerDao) {
		this.answerDao = answerDao;
	}
    
    public void setAnswer(List<Answers> answer) {
        this.answers = answer;
    }

	public void addanswer(Answers answer) {
		answerDao.addAnswer(answer);	
	}

	public void updaterecipe(Answers answer) {
		answerDao.updateAnswer(answer);
	}
		
	public void deleteAnswer(int answerID){
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Answers> getAnswers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAnswers(List<Answers> answers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Answers> getanswersbyID(int questionID) {
		List<Answers> answers = answerDao.getanswerbyID(questionID);
		return answers;
	}

	@Override
	public void updateAnswer(Answers answer) {
		// TODO Auto-generated method stub
		
	}
	
	public void addsub(int answerID, SubQA sub) {
		Answers a = answerDao.getanswerbyId(answerID);
		a.addSub(sub);
		answerDao.updateAnswer(a);
	}
	
	public void Award(int questionID, int answerID) {
		Questions q = questionDao.getquestionbyID(questionID);
		q.setState(false);
		Answers a = answerDao.getanswerbyId(answerID);
		a.setAcceptence(true);
		
	}

}