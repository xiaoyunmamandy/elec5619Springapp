package au.usyd.elec5619.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.DAO.CategoryDAO;
import au.usyd.elec5619.DAO.RecipeDAO;
import au.usyd.elec5619.domain.Category;
import au.usyd.elec5619.domain.Recipe;
@Transactional
@Service
public class Testservice {
	@Autowired
	public RecipeDAO recipeDAO;
	@Autowired
	public CategoryDAO categoryDAO;
	
	private List<Recipe> recipes;
	public String testmethod() {
		return "the spring project";
	}
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
	
	public void addrecipe(Recipe recipe) {
		recipeDAO.addRecipe(recipe);
	}
	
	public Recipe getrecipebyID(int recipeID) {
		Recipe recipe = recipeDAO.getrecipebyID(recipeID);
		return recipe;
	}
	
	public List<Category> getallcategories(){
		List<Category> category = new ArrayList<Category>();
		category = categoryDAO.getallcategories();
		return category;
	}

}
