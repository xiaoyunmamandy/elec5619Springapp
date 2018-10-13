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

import au.usyd.elec5619.DAO.RecipeDAO;
import au.usyd.elec5619.domain.Recipe;


@Transactional
@Service(value="recipecreater")
public class SimpleRecipecreater implements Recipecreater{
	
	@Autowired
	public RecipeDAO recipeDAO;
	
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
	//将图片文件存到server的制定文件夹中，相对路径。重新部署后文件清空，未解决
	public String uploadpicture(MultipartFile file, String serverpath) throws Exception, IOException{
		//String localpath = "D:\\apache-tomcat-8.0.53\\webapps\\elec5619Springapp\\img\\";
		String originalFilename = file.getOriginalFilename();
		String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
		File newFile = new File(serverpath+'\\'+newFileName);
		file.transferTo(newFile);
		String url = serverpath+newFileName;
		return url;
	}
}
