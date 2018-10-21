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

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
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
	
	@RequestMapping(value="/addpictureform", method=RequestMethod.GET)
	public String showcreaterecipepic() {
		return "addpicture";
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
