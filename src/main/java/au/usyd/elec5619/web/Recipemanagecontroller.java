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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.elec5619.domain.Category;
import au.usyd.elec5619.domain.Ingredient;
import au.usyd.elec5619.domain.Recipe;
import au.usyd.elec5619.domain.Step;
import au.usyd.elec5619.service.Recipecreater;
import au.usyd.elec5619.service.Testservice;

@Controller
public class Recipemanagecontroller {
	@Autowired
	private Testservice testservice;
	
	@Autowired
	private Recipecreater recipecreater;
	//把category调出来 放下拉刘表
	@ModelAttribute("category")
	public List<Category> getallcategory(){
		List<Category> category = testservice.getallcategories();
		System.out.println(category);
//		List<String> category = new ArrayList<String>();
//		category.add("Dessert");
//		category.add("chinese cuisine");
//		category.add("Indian cuisine");
//		category.add("English cuisine");
//		category.add("Soup");
//		category.add("1");
		return category;
	}
	//@ModelAttribute("category")
//	public Map<String, String> getallcategory(){
//		Map<String, String> categoryList = new HashMap<String, String>();		
//		categoryList.put("1", "Dessert");
//		categoryList.put("2", "chinese cuisine");
//		categoryList.put("3", "Indian cuisine");
//		categoryList.put("4", "English cuisine");
//		categoryList.put("5", "Soup");
//		return categoryList;
//	}
	//用户添加新菜谱页面
	@RequestMapping(value="/createrecipe", method=RequestMethod.GET)
	public String createrecipe() {
		return "createrecipe";
	}
	
	//提交新菜谱
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String addrecipehandler(HttpServletRequest request,HttpServletResponse response) {
		//Recipe recipe = new Recipe(request.getParameter("recipeName"),Integer.parseInt(request.getParameter("cookTime")),Integer.parseInt(request.getParameter("servepeopleno")),request.getParameter("dishImg"),request.getParameter("tips"),Integer.parseInt(request.getParameter("categoryID")),Integer.parseInt(request.getParameter("userID")));
		//System.out.println(recipe.getcookTime());
		//System.out.println(request.getParameter("recipeName"));
		//testservice.addrecipe(recipe);
		return "home";
	}
	
	@RequestMapping(value="/getrecipebyid", method=RequestMethod.GET)
	public String getrecipebyid() {
		return "getrecipebyid";
	}
	
	@RequestMapping(value="/getrecipebyidresult", method=RequestMethod.POST)
	public ModelAndView getrecipebyidresult(HttpServletRequest request,HttpServletResponse response) {
		Recipe recipe = testservice.getrecipebyID(Integer.parseInt(request.getParameter("getrecipebyID")));
		List<Ingredient> ingredientlist = recipe.getIngredientlist();
		List<Step> steplist = recipe.getSteplist();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("recipes", recipe);
		myModel.put("ingredients", ingredientlist);
		myModel.put("steps", steplist);
		Step step = steplist.get(0);
		System.out.println(step.getdescription());
		Ingredient ingre = ingredientlist.get(0);
		System.out.println(ingre.getIngredientName());
		return new ModelAndView("thereciperesult","model",myModel);
	}
	
	//加载新recipe form
	@RequestMapping(value="/showcreaterecipeform", method=RequestMethod.GET)
	public String showcreaterecipeform() {
		return "newrecipecreater";
	}
	//添加recipe，有steps
	@RequestMapping(value="/newaddrecipe", method=RequestMethod.POST)
	@ResponseBody
	public String addnewrecipe(HttpServletRequest request,HttpServletResponse response, Integer[] id, String[] name, String[] pwd) {
		//Step step = new Step(Integer.parseInt(request.getParameter("stepno")),request.getParameter("description"), request.getParameter("stepImg"));
		List<Step> steplist = new ArrayList<Step>();
		for (int i = 0; i < id.length; i++ ) {		
            Step step = new Step();
            step.setstepsno(id[i]);
            step.setdescription(name[i]);
            step.setstepImg(pwd[i]);
            steplist.add(step);
            System.out.println(id[i]);
            System.out.println(name[i]);
            System.out.println(name[i]);
        }
		//Recipetest recipetest = new Recipetest(request.getParameter("recipeName"),Integer.parseInt(request.getParameter("cookTime")),steplist);
		//recipecreater.addrecipe(recipetest);
		return "home";
	}
	//添加完整菜谱
	@RequestMapping(value="/addrecipetotal", method=RequestMethod.POST)
	@ResponseBody
	public String addrecipetotal(HttpServletRequest request,HttpServletResponse response, String[] ingredientName, String[] ingredientAmount, String[] description, @RequestParam("dish_img") MultipartFile dishfile,@RequestParam("steppicture") MultipartFile[] file)  throws Exception, IOException {
		//生成ingredient list
		List<Ingredient> ingredientlist = new ArrayList<Ingredient>();
		for (int i = 0; i <ingredientName.length; i++) {
			Ingredient ingredient = new Ingredient();
			ingredient.setIngredientName(ingredientName[i]);
			ingredient.setIngredientAmount(ingredientAmount[i]);
			ingredientlist.add(ingredient);
		}
		//将图片存储到指定文件夹中
		String serverpath = request.getSession().getServletContext().getRealPath("img");
		String dishpath = recipecreater.uploadpicture(dishfile,serverpath);
		//创建step list
		List<Step> steplist = new ArrayList<Step>();
		for (int i = 0; i < description.length; i++ ) {		
            Step step = new Step();
            int stepid=1;
            step.setstepsno(stepid);
            step.setdescription(description[i]);
            String imgpath = recipecreater.uploadpicture(file[i], serverpath);
            System.out.println(imgpath);
            step.setstepImg(imgpath);
            steplist.add(step);
            stepid++;
        }
		//用session获取用户id
		int userID = 1;
		Recipe recipe = new Recipe(request.getParameter("recipeName"),Integer.parseInt(request.getParameter("cookTime")),Integer.parseInt(request.getParameter("servepeopleno")),dishpath ,request.getParameter("tips"),Integer.parseInt(request.getParameter("categoryID")), userID ,ingredientlist,steplist);
		recipecreater.addrecipe(recipe);
		return "home";
	}
	//加载更新页面 需要recipeid
	@RequestMapping(value="/updatepage/{recipeID}", method=RequestMethod.GET)
	public ModelAndView updatepage(@PathVariable("recipeID") int recipeID, HttpServletRequest request,HttpServletResponse response) {
		Recipe recipe = testservice.getrecipebyID(recipeID);
		List<Ingredient> ingredientlist = recipe.getIngredientlist();
		List<Step> steplist = recipe.getSteplist();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("recipes", recipe);
		myModel.put("ingredients", ingredientlist);
		myModel.put("steps", steplist);
		return new ModelAndView("updaterecipe","model",myModel);
	}
	//更新菜谱
	@RequestMapping(value="/updaterecipe", method=RequestMethod.POST)
	public String updaterecipe(HttpServletRequest request,HttpServletResponse response, Integer[] ingredientID, String[] ingredientName, String[] ingredientAmount, Integer[] stepsID, Integer[] stepid, String[] description, String[] originstepImg, @RequestParam("dish_img") MultipartFile dishfile,@RequestParam("steppicture") MultipartFile[] file) throws Exception, IOException{
		List<Ingredient> ingredientlist = new ArrayList<Ingredient>();
		for (int i = 0; i <ingredientName.length; i++) {
			Ingredient ingredient = new Ingredient();
			ingredient.setIngredientID(ingredientID[i]);
			ingredient.setIngredientName(ingredientName[i]);
			ingredient.setIngredientAmount(ingredientAmount[i]);
			ingredientlist.add(ingredient);
		}
		//判断是否需要更新照片
		String serverpath = request.getSession().getServletContext().getRealPath("img");
		String dishpath;
		String filename = dishfile.getOriginalFilename();
		System.out.println(filename);
		if(dishfile.getOriginalFilename()!="") {
			System.out.println(1);
			dishpath = recipecreater.uploadpicture(dishfile,serverpath);
		}
		else {
			dishpath = request.getParameter("origindishImg");
			System.out.println(2);
		}
		List<Step> steplist = new ArrayList<Step>();
		for (int i = 0; i < stepid.length; i++ ) {		
            Step step = new Step();
            step.setstepsID(stepsID[i]);
            step.setstepsno(stepid[i]);
            step.setdescription(description[i]);
            if(file[i].getOriginalFilename()!="") {
            	String imgpath = recipecreater.uploadpicture(file[i], serverpath);
            	step.setstepImg(imgpath);
            }
            else {
            	String imgpath = originstepImg[i];
            	step.setstepImg(imgpath);
            }
            steplist.add(step);
        }
		int userID = 1;
		Recipe recipe = new Recipe(request.getParameter("recipeName"),Integer.parseInt(request.getParameter("cookTime")),Integer.parseInt(request.getParameter("servepeopleno")),dishpath ,request.getParameter("tips"),Integer.parseInt(request.getParameter("categoryID")), userID ,ingredientlist,steplist);
		recipe.setrecipeID(Integer.parseInt(request.getParameter("recipeID")));
		recipecreater.updaterecipe(recipe);
		return "home";
	}
	
	//删除菜谱
	@RequestMapping(value="/deleterecipe/{recipeID}", method=RequestMethod.GET)
	public String deleterecipe(@PathVariable("recipeID") int recipeID, HttpServletRequest request,HttpServletResponse response) {
		//String recipeID = request.getParameter("recipeID");
		//System.out.println("cccc"+recipeID);
		recipecreater.deleterecipe(recipeID);
		return "home";
	}
	
	@RequestMapping(value="/allrecipes", method=RequestMethod.GET)
	public ModelAndView getallrecipes(HttpServletRequest request,HttpServletResponse response) {
		List<Recipe> recipelist = recipecreater.getallrecipes();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("recipes", recipelist);
		return new ModelAndView("showrecipes","model",myModel);
	}
	
	//显示菜谱详情
	@RequestMapping(value="/recipedetails/{id}", method=RequestMethod.GET)
	public ModelAndView showrecipedetails(@PathVariable("id") int id) {
		Recipe recipe = testservice.getrecipebyID(id);
		String categoryName = recipecreater.getcategoryname(recipe.getcategoryID());
		List<Ingredient> ingredientlist = recipe.getIngredientlist();
		List<Step> steplist = recipe.getSteplist();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("recipes", recipe);
		myModel.put("ingredients", ingredientlist);
		myModel.put("steps", steplist);
		myModel.put("categoryName", categoryName);
		return new ModelAndView("recipedetail","model",myModel);
	}
	
	//按类别查菜谱
	@RequestMapping(value="/categoryrecipe/{categoryID}", method=RequestMethod.GET)
	public ModelAndView getrecipebycategory(@PathVariable("categoryID") int categoryID) {
		//String categoryID = request.getParameter("categoryID");
		System.out.println(categoryID);
		//String categoryID = "4";
		List<Recipe> recipelist = recipecreater.getrecipebycategory(categoryID);
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("recipes", recipelist);
		Recipe recipe = recipelist.get(0);
		System.out.println(recipe.getrecipeName());
		System.out.println("1111");
		return new ModelAndView("showrecipes","model",myModel);
	}
	//查询用户发布信息
	@RequestMapping(value="/userrecipe/{userID}", method=RequestMethod.GET)
	public ModelAndView getrecipebyuser(@PathVariable("userID") int userID) {
		List<Recipe> recipelist = recipecreater.getrecipebyuser(userID);
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("recipes", recipelist);
		return new ModelAndView("showrecipesbyuser","model",myModel);
	}

}
