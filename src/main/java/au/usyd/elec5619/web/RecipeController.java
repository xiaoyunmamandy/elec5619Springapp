package au.usyd.elec5619.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import au.usyd.elec5619.service.Recipecreater;
import au.usyd.elec5619.domain.Recipe;

public class RecipeController implements Controller {
	protected final Log logger = LogFactory.getLog(getClass());
	
	private Recipecreater recipecreater;
	
	@Override
	//ModelAndView用来存储处理完后的结果数据，以及显示该数据的视图。
	public ModelAndView handleRequest(HttpServletRequest arg0,HttpServletResponse arg1) throws ServletException, IOException {
		String now = (new java.util.Date()).toString();
		logger.info("Returning hello view with " + now);
		Map<String, Object> myModel = new HashMap<String, Object>(); //映射，有点像字典
		myModel.put("now", now); //将指定的值与键值关联
		myModel.put("recipes", recipecreater.getRecipes());
		
		return new ModelAndView("hello", "model", myModel);
	}
	
	public void setRecipecreater(Recipecreater recipecreater) {
		this.recipecreater = recipecreater;
	} //构造函数
}