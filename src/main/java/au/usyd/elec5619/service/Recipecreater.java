package au.usyd.elec5619.service;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import au.usyd.elec5619.domain.Category;
import au.usyd.elec5619.domain.Collection;
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
	public Recipe getrecipebyID(int recipeID);
	public List<Category> getallcategories();
	public List<Recipe> getrecipebycooktime(int cooktime);
	public List<Recipe> getrecipebytimeandtype(int categoryID, int cookTime);
	public void addcollection(Collection collection);
	public List<Recipe> getrecipecollectbyuser(int userID);
	public void deletecollection(int userID,int recipeID);
	public boolean checkcollection(int userID, int recipeID);
	public void addcategory(Category category);
	public void deletecategory(int categoryID);
}