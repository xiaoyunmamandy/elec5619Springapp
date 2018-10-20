package au.usyd.elec5619.service;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import au.usyd.elec5619.domain.Recipe;



public interface Recipecreater extends Serializable{

	public List<Recipe> getRecipes();
	public String test();
	public void addrecipe(Recipe recipe);
	public String uploadpicture(MultipartFile file,String serverpath)throws Exception, IOException;
    public void updaterecipe(Recipe recipe);
	public void deleterecipe(int recipeID);
	public List<Recipe> getallrecipes();
	public String getcategoryname(int id);
	public List<Recipe> getrecipebycategory(int categoryID);
	public List<Recipe> getrecipebyuser(int userID);
	
}