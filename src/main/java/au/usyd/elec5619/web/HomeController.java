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

import au.usyd.elec5619.service.Recipecreater;
import au.usyd.elec5619.service.Testservice;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private Testservice testservice;
	
	@Autowired
	private Recipecreater recipecreater;
	
//	public void setRecipecreater(Recipecreater recipecreater) {
//		this.recipecreater = recipecreater;
//	} //构造函数
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView home1() {
		Map<String, Object> myModel = new HashMap<String, Object>();
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		
		String formattedDate = dateFormat.format(date);
		myModel.put("serverTime", formattedDate);
		String message = testservice.testmethod();
		System.out.println(message);

		myModel.put("welcome", message);
		myModel.put("recipes", testservice.getRecipes());
		return new ModelAndView("hometest","model",myModel);
	}
	
	//接口实现有问题，解决
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public ModelAndView home2() {
		Map<String, Object> myModel = new HashMap<String, Object>();
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		
		String formattedDate = dateFormat.format(date);
		myModel.put("serverTime", formattedDate);
		myModel.put("welcome", "welcome page");
		// setRecipecreater(recipecreater);
		myModel.put("recipes", recipecreater.getRecipes());
		return new ModelAndView("hometest","model",myModel);
	}
	@RequestMapping(value="/addpictureform", method=RequestMethod.GET)
	public String showcreaterecipepic() {
		return "addpicture";
	}
	//添加图片测试 单张图片
	@RequestMapping(value="/addpicture", method=RequestMethod.POST)
	public String addpicture(@RequestParam("file_img") MultipartFile file, HttpServletRequest request,HttpServletResponse response) throws Exception, IOException{
		//String localpath = "F:\\ELEC5619\\images";
		String localpath = request.getSession().getServletContext().getRealPath("img");
		String originalFilename = file.getOriginalFilename();
		String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
		File newFile = new File(localpath,newFileName);
		file.transferTo(newFile);
		System.out.println(localpath);
		System.out.println(originalFilename);
		System.out.println(newFileName);
		return "home";
	}
	//添加多张图片，带service调用
	@RequestMapping(value="/addpictures", method=RequestMethod.POST)
	public String addpictures(@RequestParam("dish_img") MultipartFile dishfile,@RequestParam("file_img") MultipartFile[] file, HttpServletRequest request,HttpServletResponse response) throws Exception, IOException{
		String serverpath = request.getSession().getServletContext().getRealPath("img");
		String dishurl = recipecreater.uploadpicture(dishfile,serverpath);
		System.out.println(dishurl);
		if(file!=null&&file.length>0) {
			for(int i=0;i<file.length;i++) {
				MultipartFile thefile = file[i];
				String url = recipecreater.uploadpicture(thefile,serverpath);
				System.out.println(url);
			}
		}
		return "home";
	}
}
