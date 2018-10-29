package au.usyd.elec5619.web;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.elec5619.domain.User;
import au.usyd.elec5619.service.Recipecreater;
import au.usyd.elec5619.service.Usercreater;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private Recipecreater recipecreater;
	@Autowired
	private Usercreater usercreater;
	
//	public void setRecipecreater(Recipecreater recipecreater) {
//		this.recipecreater = recipecreater;
//	} //构造函数
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model,HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		HttpSession session = request.getSession(true);
		String username = (String)session.getAttribute("username");
		Map<String, Object> myModel = new HashMap<String, Object>();
		System.out.println(username);
		if(username!=null) {
			myModel.put("username", username);
			int userid = (Integer) session.getAttribute("userid");
			myModel.put("userid", userid);
		}
		return new ModelAndView("home", "model", myModel);
	}
	
	@RequestMapping(value = "/admincenter", method = RequestMethod.GET)
	public String admincenter(Model model) {
		return "admincenter";
	}
	//显示登录页面
		@RequestMapping(value = "/adminloginpage", method = RequestMethod.GET)
		public String showloginpage() {
			return "adminloginpage";
		}
		//登录
		@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
		public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
			String username = request.getParameter("adusername");
			String pwd = request.getParameter("password");
			int result = usercreater.adminlogincheck(username, pwd);
			if(result==1) {
				Map<String, Object> myModel = new HashMap<String, Object>();
				myModel.put("nouser", 1);
				myModel.put("pwdfalse", 0);
				return new ModelAndView("adminloginpage", "model", myModel);
			}
			else if(result==0) {
				Map<String, Object> myModel = new HashMap<String, Object>();
				myModel.put("nouser", 0);
				myModel.put("pwdfalse", 1);
				return new ModelAndView("adminloginpage", "model", myModel);
			}
			else {
				Map<String, Object> myModel = new HashMap<String, Object>();
				return new ModelAndView("admincenter", "model", myModel);
			}
		}

}
