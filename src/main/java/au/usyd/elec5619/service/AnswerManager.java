package au.usyd.elec5619.service;

import java.io.Serializable;
import java.util.List;

import au.usyd.elec5619.DAO.AnswerDao;
import au.usyd.elec5619.domain.Answers;
import au.usyd.elec5619.domain.SubQA;

public interface AnswerManager extends Serializable{
 
    public List<Answers> getAnswers();
    
    public void setAnswers(List<Answers> answers);
    
    public void addanswer(Answers answer);
    
    public void updateAnswer(Answers answer);

    public void deleteAnswer(int answerID);
    
    public void setAnswerDAO(AnswerDao answerDao);
    
	public List<Answers> getanswersbyID(int questionID);
	
	public void addsub(int anserID, SubQA sub);
    	
    
    
}