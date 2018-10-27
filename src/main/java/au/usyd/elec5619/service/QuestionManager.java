package au.usyd.elec5619.service;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import au.usyd.elec5619.DAO.QuestionDao;
import au.usyd.elec5619.domain.Questions;

public interface QuestionManager extends Serializable{
 
    public List<Questions> getQuestions();
    
    public void setQuestions(List<Questions> question);
    
    public void addquestion(Questions question);
    
    public void updateQuestion(Questions question);

    public void deleteQuestion(int questionID);
    	
    public void setQuestionDAO(QuestionDao questionDao);
    
    public List<Questions> getallquestions();
    
	public Questions getquestionbyID(int questionID);
	
	public List<Questions> getquestionsbyuser(int userID);
    
}