package au.usyd.elec5619.web;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.elec5619.domain.Answers;
import au.usyd.elec5619.domain.Questions;
import au.usyd.elec5619.service.AnswerManager;
import au.usyd.elec5619.service.QuestionManager;


@Controller
@RequestMapping(value="/**")
public class QuestionController {

	@Autowired
	private  QuestionManager questionManager;
	@Autowired
	private  AnswerManager answerManager;
	
	@RequestMapping(value="/CreateQuestion/{userid}", method=RequestMethod.GET)
	public String CreateQuestion(@PathVariable("userid") int userid,Model model) {
		model.addAttribute("userid", userid);
		return "creatQuestions";
	}
	//Ìí¼Óquestion
	@RequestMapping(value="/addquestions", method=RequestMethod.POST)
	public String addquestions(HttpServletRequest request,HttpServletResponse response){
		Questions question = new Questions(request.getParameter("title"),request.getParameter("description"),true,Integer.parseInt(request.getParameter("userid")),Integer.parseInt(request.getParameter("Worth")));
		questionManager.addquestion(question);
		return "home";
	}
	
	@RequestMapping(value="/allquestions", method=RequestMethod.GET)
	public ModelAndView getallquestions(HttpServletRequest request,HttpServletResponse response) {
		List<Questions> questionslist = questionManager.getallquestions();
		Map<String, Object> myModel = new HashMap<String, Object>();
		System.out.println(questionslist.get(0).getTitle());
		myModel.put("questions", questionslist);
		HttpSession session = request.getSession(true);
		if(session.getAttribute("username")!="") {
			String username = (String)session.getAttribute("username");
			int userid = (Integer) session.getAttribute("userid");
			System.out.println(username);
			myModel.put("username", username);
			myModel.put("userid", userid);
		}
		return new ModelAndView("ShowQuestions","model",myModel);
	}
	
	@RequestMapping(value="/userquestions", method=RequestMethod.GET)
	public ModelAndView getquestionsbyuser(HttpServletRequest request,HttpServletResponse response) {
		List<Questions> questionslist = questionManager.getquestionsbyuser(1);
		Map<String, Object> myModel = new HashMap<String, Object>();
		System.out.println(questionslist.get(0).getTitle());
		myModel.put("questions", questionslist);
		request.getSession().setAttribute("username", "xxx");
		return new ModelAndView("userquestions","model",myModel);
	}
	
	@RequestMapping(value="/questiondetails/{id}", method=RequestMethod.GET)
	public ModelAndView showrecipedetails(@PathVariable("id") int id,HttpServletRequest request,HttpServletResponse response) {
		Questions question = questionManager.getquestionbyID(id);
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("question", question);
		List<Answers> answerslist = answerManager.getanswersbyID(id);
		myModel.put("answers", answerslist);
		request.getSession().setAttribute("username", "xxx");
		HttpSession session = request.getSession(true);
		if(session.getAttribute("username")!="") {
			String username = (String)session.getAttribute("username");
			int userid = (Integer) session.getAttribute("userid");
			System.out.println(username);
			myModel.put("username", username);
			myModel.put("userid", userid);
		}
		return new ModelAndView("QuestionDetails","model",myModel);
	}
}
