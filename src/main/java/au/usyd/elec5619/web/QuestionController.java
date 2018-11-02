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
import au.usyd.elec5619.domain.User;
import au.usyd.elec5619.service.AnswerManager;
import au.usyd.elec5619.service.QuestionManager;
import au.usyd.elec5619.service.Usercreater;


@Controller
@RequestMapping(value="/**")
public class QuestionController {

	@Autowired
	private  QuestionManager questionManager;
	@Autowired
	private  AnswerManager answerManager;
	@Autowired
	private Usercreater usercreater;
	@RequestMapping(value="/CreateQuestion/{userid}", method=RequestMethod.GET)
	public String CreateQuestion(@PathVariable("userid") int userid,Model model) {
		model.addAttribute("userid", userid);
		User user = usercreater.getUserById(userid);
		int point = user.getPoints();
		System.out.println(point);
		model.addAttribute("currentpoints", point);
		return "creatQuestions";
	}
	//Ìí¼Óquestion
	@RequestMapping(value="/addquestions", method=RequestMethod.POST)
	public String addquestions(HttpServletRequest request,HttpServletResponse response){
		User user = usercreater.getUserById(Integer.parseInt(request.getParameter("userid")));
		Questions question = new Questions(request.getParameter("title"),request.getParameter("description"),true,Integer.parseInt(request.getParameter("userid")),Integer.parseInt(request.getParameter("Worth")),user.getUserName());
		questionManager.addquestion(question);
		return "redirect:/allquestions";
	}
	
	@RequestMapping(value="/allquestions", method=RequestMethod.GET)
	public ModelAndView getallquestions(HttpServletRequest request,HttpServletResponse response) {
		List<Questions> questionslist = questionManager.getallquestions();
		Map<String, Object> myModel = new HashMap<String, Object>();
		//System.out.println(questionslist.get(0).getTitle());
		myModel.put("questions", questionslist);
		HttpSession session = request.getSession(true);
		if(session.getAttribute("username")!=null) {
			String username = (String)session.getAttribute("username");
			int userid = (Integer) session.getAttribute("userid");
			System.out.println(username);
			myModel.put("username", username);
			myModel.put("userid", userid);
		}
		return new ModelAndView("ShowQuestions","model",myModel);
	}
	
	@RequestMapping(value="/userquestions/{userid}", method=RequestMethod.GET)
	public ModelAndView getquestionsbyuser(HttpServletRequest request,HttpServletResponse response,@PathVariable("userid") int userid) {
		List<Questions> questionslist = questionManager.getquestionsbyuser(userid);
		User user = usercreater.getUserById(userid);
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("questions", questionslist);
		myModel.put("user", user);
		return new ModelAndView("userquestions","model",myModel);
	}
	
	@RequestMapping(value="/questiondetails/{id}", method=RequestMethod.GET)
	public ModelAndView showrecipedetails(@PathVariable("id") int id,HttpServletRequest request,HttpServletResponse response) {
		Questions question = questionManager.getquestionbyID(id);
		if(question.getState()==false) {
			Map<String, Object> myModel = new HashMap<String, Object>();
			myModel.put("question", question);
			List<Answers> answerslist = answerManager.getanswersbyID(id);
			myModel.put("answers", answerslist);
			HttpSession session = request.getSession(true);
			int userid = (Integer)session.getAttribute("userid");
			User user = usercreater.getUserById(userid);
			myModel.put("user", user);
			return new ModelAndView("questiondetailfinish","model",myModel);
		}
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("question", question);
		List<Answers> answerslist = answerManager.getanswersbyID(id);
		myModel.put("answers", answerslist);
		HttpSession session = request.getSession(true);
		int userid = (Integer)session.getAttribute("userid");
		User user = usercreater.getUserById(userid);
		myModel.put("user", user);
		return new ModelAndView("QuestionDetails","model",myModel);
	}
}
