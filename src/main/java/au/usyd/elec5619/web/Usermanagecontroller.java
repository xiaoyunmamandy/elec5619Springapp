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

import au.usyd.elec5619.domain.User;
import au.usyd.elec5619.service.Usercreater;
import au.usyd.elec5619.service.Recipecreater;
import au.usyd.elec5619.service.UserService;

@Controller
@RequestMapping(value = "/user/**")
public class Usermanagecontroller {

	@Autowired
	private Usercreater usercreater;

	@Autowired
	private Recipecreater recipecreater;

	// 显示注册页面
	@RequestMapping(value = "/showcreateuserform", method = RequestMethod.GET)
	public String showcreateuserform() {
		return "createuser";
	}

	// 注册（添加用户）
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String register(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("personImg") MultipartFile personImg) throws Exception, IOException {
		String serverpath = request.getSession().getServletContext().getRealPath("img");
		String personImgpath = recipecreater.uploadpicture(personImg, serverpath);
		User user = new User(request.getParameter("userName"), request.getParameter("password"),
				request.getParameter("email"), 3, personImgpath);
		usercreater.addUser(user);
		return "home";
	}
	//显示登录页面
	@RequestMapping(value = "/loginpage", method = RequestMethod.GET)
	public String showloginpage() {
		return "loginpage";
	}
	//登录
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String pwd = request.getParameter("password");
		int result = usercreater.logincheck(email, pwd);
		if(result==1) {
			Map<String, Object> myModel = new HashMap<String, Object>();
			myModel.put("nouser", 1);
			myModel.put("pwdfalse", 0);
			return new ModelAndView("loginpage", "model", myModel);
		}
		else if(result==0) {
			Map<String, Object> myModel = new HashMap<String, Object>();
			myModel.put("nouser", 0);
			myModel.put("pwdfalse", 1);
			return new ModelAndView("loginpage", "model", myModel);
		}
		else {
			User user = usercreater.getuserbyemail(email);
			String username = user.getUserName();
			int userid = user.getId();
			request.getSession().setAttribute("username", username);
			request.getSession().setAttribute("userid", userid);
			Map<String, Object> myModel = new HashMap<String, Object>();
			myModel.put("username", username);
			return new ModelAndView("home", "model", myModel);
		}
	}
	//登出
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("username", "");
		request.getSession().setAttribute("userid", "");
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("username", "logout");
		return new ModelAndView("home","model",myModel);
	}
	//进入个人中心 个人信息详情
	@RequestMapping(value = "/selfinfo", method = RequestMethod.GET)
	public ModelAndView showselfcenter(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		int userid = (Integer) session.getAttribute("userid");
		//String username = (String)session.getAttribute("username");
		//int userID=1;
		User user = usercreater.getUserById(userid);
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("user", user);
		return new ModelAndView("selfinformation","model",myModel);
	}
	//用户点击修改个人信息功能
	@RequestMapping(value = "/updateinfopage/{userid}", method = RequestMethod.GET)
	public ModelAndView infoupdateform(@PathVariable("userid") int userid,HttpServletRequest request, HttpServletResponse response) {
		User user = usercreater.getUserById(userid);
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("user", user);
		return new ModelAndView("updateselfinfo","model",myModel);
	}
	@RequestMapping(value = "/updatepwdpage/{userid}", method = RequestMethod.GET)
	public ModelAndView pwdupdateform(@PathVariable("userid") int userid,HttpServletRequest request, HttpServletResponse response) {
		User user = usercreater.getUserById(userid);
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("user", user);
		return new ModelAndView("updatepwd","model",myModel);
	}
	//用户修改个人信息
	@RequestMapping(value = "/updateinformation", method = RequestMethod.POST)
	public String updaterecipe(HttpServletRequest request, HttpServletResponse response, @RequestParam("personImg") MultipartFile personImg) throws Exception, IOException {
		String originImg= request.getParameter("orignpersonImg");
		String personImgpath;
		if(personImg.getOriginalFilename()!="") {
			String serverpath = request.getSession().getServletContext().getRealPath("img");
			personImgpath = recipecreater.uploadpicture(personImg, serverpath);
		}
		else {
			personImgpath=originImg;
		}
		User user = new User(request.getParameter("userName"), request.getParameter("password"),
				request.getParameter("email"), Integer.parseInt(request.getParameter("points")), personImgpath);
		user.setId(Integer.parseInt(request.getParameter("userid")));
		usercreater.updateUser(user);
		int userID=Integer.parseInt(request.getParameter("userid"));
		request.getSession().setAttribute("userid", userID);
		
		return "redirect:/user/selfinfo";
    }

	// 4
	@RequestMapping(value = "/getuserbyid", method = RequestMethod.GET)
	public String getrecipebyid() {
		return "getrecipebyid";
	}

	// 5 change the type of userid from int to string
	@RequestMapping(value = "/deleteuser/{userID}", method = RequestMethod.GET)
	public String deleterecipe(@PathVariable("userID") int userID, HttpServletRequest request,
			HttpServletResponse response) {
		usercreater.deleteUser(userID);
		return "redirect:/recipe/userrecipe/1";
	}

	// 7 add user

	// update information

	@RequestMapping(value = "/updateinformation/{userID}", method = RequestMethod.GET)
	public ModelAndView updatepage(@PathVariable("userID") int userID, HttpServletRequest request,
			HttpServletResponse response) {
		User user = usercreater.getUserById(userID);
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("user", user);
		// myModel.put("userName", user.getName());
		// myModel.put("password", user.getPassword());
		// myModel.put("email", user.getEmail());
		return new ModelAndView("updateinformation", "model", myModel);
	}


//	@RequestMapping(value = "/updateinformation", method = RequestMethod.POST)
//	// the parameter which need to send to updaterecipe(i dont know)
//	public String updaterecipe(HttpServletRequest request, HttpServletResponse response, int userid, String userName,
//			String password, String email) throws Exception, IOException {
//		User user = new User();
//		user.setName(userName);
//		user.setPassword(password);
//		user.setEmail(email);
//		user.setId(userid);
//
//		// int userID = 1;
//		// User user1 = new
//		// User(request.getParameter("userName"),request.getParameter("password"),request.getParameter("email"));
//		usercreater.updateUser(user);
//		return "redirect:/user/updateinformation/" + userid;
//	}

	// verify if the email has been used
	@RequestMapping(value = "/register/{userID}", method = RequestMethod.GET)
	public ModelAndView toverifyemail(@PathVariable("userID") int userID, HttpServletRequest request,
			HttpServletResponse response) {
		User user = usercreater.getUserById(userID);
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("email", user.getEmail());
		// myModel.put("userName", user.getName());
		// myModel.put("password", user.getPassword());
		// myModel.put("email", user.getEmail());
		return new ModelAndView("verifyemail", "model", myModel);
	}

	// verify if the email has been used
	@RequestMapping(value = "/verifyemail", method = RequestMethod.POST)
	// the parameter which need to send to updaterecipe(i dont know)
	public boolean verifyemail(HttpServletRequest request, HttpServletResponse response, String email)
			throws Exception, IOException {
		boolean verification = true;
		User user = new User();
		List<User> userlist = new ArrayList<User>();
		for (User usr : userlist) {
			if (email.equals(usr.getEmail())) {
				verification = false;
			} else {
				verification = true;
			}
		}
		return verification;
	}

	@RequestMapping(value = "/personalinformation/{userID}", method = RequestMethod.GET)
	public ModelAndView personalpage(@PathVariable("userID") int userID, HttpServletRequest request,
			HttpServletResponse response) {
		User user = usercreater.getUserById(userID);
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("user", user);
		// myModel.put("userName", user.getName());
		// myModel.put("password", user.getPassword());
		// myModel.put("email", user.getEmail());
		return new ModelAndView("personalinformation", "model", myModel);
	}

	// personal information
//	@RequestMapping(value = "/personalinformation", method = RequestMethod.POST)
//	public String personalinfor(HttpServletRequest request, HttpServletResponse response, int userid, String userName,
//			String password, String email, @RequestParam("dish_img") MultipartFile dishfile,
//			@RequestParam("steppicture") MultipartFile[] file) throws Exception, IOException {
//		
//
//		User user = new User();
//
//		
//		String serverpath = request.getSession().getServletContext().getRealPath("img");
//		String dishpath = usercreater.uploadpicture(dishfile, serverpath);
//
//		usercreater.updateUser(user);
//		return "redirect:/user/updateinformation/" + userid;
//	}
}
