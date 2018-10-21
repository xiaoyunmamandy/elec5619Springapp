package au.usyd.elec5619.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import au.usyd.elec5619.DAO.CategoryDAO;
import au.usyd.elec5619.DAO.RecipeDAO;
import au.usyd.elec5619.domain.Category;
import au.usyd.elec5619.domain.Recipe;
import au.usyd.elec5619.domain.Step;


@Transactional
@Service(value="recipecreater")
public class SimpleRecipecreater implements Recipecreater{
	
	@Autowired
	public RecipeDAO recipeDAO;
	
	@Autowired
	public CategoryDAO categoryDAO;
	
	public void setRecipeDAO(RecipeDAO recipeDAO) {
		this.recipeDAO = recipeDAO;
	}
	
	
	private List<Recipe> recipes;
	
	public List<Recipe> getRecipes(){
		recipes = new ArrayList<Recipe>();
		Recipe recipe = new Recipe();
		recipe.setrecipeID(1);
		recipe.setrecipeName("Muffin");
		recipe.setcookTime(100);
		recipe.setservepeopleno(3);
		recipe.setdishImg("1234");
		recipe.settips("remember preheat the ovan");
		recipe.setuserID(2);
		recipe.setcategoryID(2);
		recipes.add(recipe);
		
		recipe = new Recipe();
		recipe.setrecipeID(2);
		recipe.setrecipeName("chocolate");
		recipe.setcookTime(120);
		recipe.setservepeopleno(5);
		recipe.setdishImg("5678");
		recipe.settips("use water");
		recipe.setuserID(4);
		recipe.setcategoryID(2);
		recipes.add(recipe);
		return recipes;
	}
	public String test() {
		return "the spring project";
	}
	public void setRecipe(List<Recipe> recipes){
		this.recipes = recipes;
	}
	
	public void addrecipe(Recipe recipe) {
		recipeDAO.addRecipe(recipe);
		
	}
	//得到所有category
	public List<Category> getallcategories(){
		List<Category> category = new ArrayList<Category>();
		category = categoryDAO.getallcategories();
		return category;
	}
	//将图片文件存到server的制定文件夹中
	public String uploadpicture(MultipartFile file, String serverpath) throws Exception, IOException{
		//String localpath = "D:\\apache-tomcat-8.0.53\\webapps\\elec5619Springapp\\img\\";
		String localpath = "F:\\ELEC5619\\images";
		String originalFilename = file.getOriginalFilename();
		String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
		File newFile = new File(localpath,newFileName);
		//File newFile = new File(serverpath+'\\'+newFileName);
		file.transferTo(newFile);
		String url = newFileName;
		return url;
	}
	
	//修改菜谱
	public void updaterecipe(Recipe recipe) {
		recipeDAO.updateRecipe(recipe);
	}
	//删除菜谱
	public void deleterecipe(int recipeID) {
		recipeDAO.deleteRecipe(recipeID);
	}
	
	//得到所有菜谱
	public List<Recipe> getallrecipes(){
		List<Recipe> recipelist = recipeDAO.getallrecipes();
		return recipelist;
	}
	public String getcategoryname(int id) {
		String categoryName = categoryDAO.getcategorynamebyID(id);
		return categoryName;
	}
	
	//按照id查询菜谱包括step，ingredients
	public Recipe getrecipebyID(int recipeID) {
		Recipe recipe = recipeDAO.getrecipebyID(recipeID);
		List<Step> steplist = recipeDAO.getallstepsforrecipe(recipeID);
		recipe.setSteplist(steplist);
		System.out.println(steplist.get(0).getdescription());
		return recipe;
	}
	//按类别查菜谱
	public List<Recipe> getrecipebycategory(int categoryID){
		List<Recipe> recipelist = recipeDAO.getrecipebycategory(categoryID);
		return recipelist;
	}
	//查询用户发布过的信息
	public List<Recipe> getrecipebyuser(int userID){
		List<Recipe> recipelist = recipeDAO.getrecipebyuser(userID);
		return recipelist;
	}
}
