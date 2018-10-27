package au.usyd.elec5619.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.elec5619.DAO.QuestionDao;
import au.usyd.elec5619.domain.Questions;


@Transactional
@Service(value="questions")
public class SimpleQuestionManager implements QuestionManager {
	
	@Autowired
	public QuestionDao questionDao;
	
	
	
	private List<Questions> questions;
    
	public void setQuestionDAO(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}
    
    public void setQuestions(List<Questions> question) {
        this.questions = question;
    }

	public void addquestion(Questions question) {
		questionDao.addQuestion(question);	
	}

	public void updateQuestion(Questions question) {
		// TODO Auto-generated method stub
		
	}
		
	public void deleteQuestion(int questionID){
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Questions> getQuestions() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Questions> getallquestions(){
		List<Questions> questionlist = questionDao.getallquestions();
		return questionlist;
	}
	
	public Questions getquestionbyID(int questionID) {
		Questions question = questionDao.getquestionbyID(questionID);
		return question;
	}
	
	public List<Questions> getquestionsbyuser(int userID){
		return questionDao.getquestionbyuser(userID);
	}


}