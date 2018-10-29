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
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.elec5619.domain.Comment;
import au.usyd.elec5619.domain.Subcomment;
import au.usyd.elec5619.domain.User;
import au.usyd.elec5619.service.Commentcreater;
import au.usyd.elec5619.service.Usercreater;

@Controller
@RequestMapping(value="/comments/**")
public class Commentmanagementcontroller {
	@Autowired
	private Commentcreater commentcreater;
	@Autowired
	private Usercreater usercreater;

	@RequestMapping(value="/showcommentform", method=RequestMethod.GET)
	public String showaddform() {
		return "addcomment";
	}

	
	
	
	//comments
	@RequestMapping(value="/addcomment", method=RequestMethod.POST)
	public String addcomment(HttpServletRequest request,HttpServletResponse response) {
		ArrayList<Subcomment> sub = new ArrayList<Subcomment>();
		HttpSession session = request.getSession(true);
		String username = (String)session.getAttribute("username");
		int userid = (Integer)session.getAttribute("userid");
		Comment comment = new Comment(userid,request.getParameter("description"),Integer.parseInt(request.getParameter("recipeID")),sub,username);
		commentcreater.addcomment(comment);
		
		return "home";
	}

	//delete
	@RequestMapping(value="/recipe/{id}", method=RequestMethod.GET)
	public ModelAndView showrecipedetails(@PathVariable("id") int id,HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> myModel = new HashMap<String, Object>();
		List<Comment> commentlist = commentcreater.getcommentbyID(id);
		myModel.put("comments", commentlist);
		request.getSession().setAttribute("username", "xxx");
		HttpSession session = request.getSession(true);
		String username = (String)session.getAttribute("username");
		return new ModelAndView("allcomments","model",myModel);
	}
	
	@RequestMapping(value="/addsub/{id}", method=RequestMethod.POST)
	public String addsub(@PathVariable("id") int id,HttpServletRequest request,HttpServletResponse response)  throws Exception, IOException {
		HttpSession session = request.getSession(true);
		String username = (String)session.getAttribute("username");
		int userid = (Integer)session.getAttribute("userid");
		Subcomment sub = new Subcomment(request.getParameter("Sub"),userid,username);
		commentcreater.addsub(id,sub);
		return "home";
	}
	
	//delete comments
	@RequestMapping(value="/deletecomment/{commentID}", method=RequestMethod.GET)
	public String deletecomment(@PathVariable("commentID") int commentID,HttpServletRequest request,HttpServletResponse response) {
		
		commentcreater.deletecomment(commentID);
		
		return "/deletecomment";

}}
