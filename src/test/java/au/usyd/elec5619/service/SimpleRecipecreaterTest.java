package au.usyd.elec5619.service;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import junit.framework.TestCase;
import au.usyd.elec5619.domain.Recipe;

public class SimpleRecipecreaterTest extends TestCase{
	private SimpleRecipecreater recipecreater;
	private List<Recipe> recipes;
	
	private static int RECIPE_COUNT = 2;
	
	private static int Muffin_ID = 1;
	private static String Muffin_name = "Muffin";
	private static int Muffin_servepeople = 2;
	private static int Muffin_cooktime = 100;
	private static String Muffin_dishimg = "12345";
	private static String Muffin_tips = "preheat oven";
	private static int Muffin_categoryID = 1;
	private static int Muffin_userID = 1;
	
	private static int cupcake_ID = 2;
	private static String cupcake_name = "cupcake";
	private static int cupcake_servepeople = 4;
	private static int cupcake_cooktime = 120;
	private static String cupcake_dishimg = "6789";
	private static String cupcake_tips = "preheat oven";
	private static int cupcake_categoryID = 1;
	private static int cupcake_userID = 2;
	
	protected void setUp() throws Exception{
		recipecreater = new SimpleRecipecreater();
		recipes = new ArrayList<Recipe>();
		
		Recipe recipe = new Recipe();
		recipe.setrecipeID(Muffin_ID);
		recipe.setrecipeName(Muffin_name);
		recipe.setcookTime(Muffin_cooktime);
		recipe.setservepeopleno(Muffin_servepeople);
		recipe.setdishImg(Muffin_dishimg);
		recipe.settips(Muffin_tips);
		recipe.setuserID(Muffin_userID);
		recipe.setcategoryID(Muffin_categoryID);
		recipes.add(recipe);
		
		recipe = new Recipe();
		recipe.setrecipeID(cupcake_ID);
		recipe.setrecipeName(cupcake_name);
		recipe.setcookTime(cupcake_cooktime);
		recipe.setservepeopleno(cupcake_servepeople);
		recipe.setdishImg(cupcake_dishimg);
		recipe.settips(cupcake_tips);
		recipe.setuserID(cupcake_userID);
		recipe.setcategoryID(cupcake_categoryID);
		recipes.add(recipe);
		
		recipecreater.setRecipe(recipes);
	}
	
	public void testGetRecipesWithNorecipes() {
		recipecreater = new SimpleRecipecreater();
		assertNull(recipecreater.getRecipes());
	}
	
	public void testGetRecipe() {
		List<Recipe> recipes = recipecreater.getRecipes();
		assertNotNull(recipes);
		assertEquals(RECIPE_COUNT,recipecreater.getRecipes().size());
		
		Recipe recipe = recipes.get(0);
		assertEquals(Muffin_ID,recipe.getrecipeID());
		assertEquals(Muffin_name,recipe.getrecipeName());
		assertEquals(Muffin_cooktime,recipe.getcookTime());
		assertEquals(Muffin_servepeople,recipe.getservepeopleno());
		assertEquals(Muffin_dishimg,recipe.getdishImg());
		assertEquals(Muffin_tips,recipe.gettips());
		assertEquals(Muffin_userID,recipe.getuserID());
		assertEquals(Muffin_categoryID,recipe.getcategoryID());
		
		recipe = recipes.get(1);
		assertEquals(cupcake_ID,recipe.getrecipeID());
		assertEquals(cupcake_name,recipe.getrecipeName());
		assertEquals(cupcake_cooktime,recipe.getcookTime());
		assertEquals(cupcake_servepeople,recipe.getservepeopleno());
		assertEquals(cupcake_dishimg,recipe.getdishImg());
		assertEquals(cupcake_tips,recipe.gettips());
		assertEquals(cupcake_userID,recipe.getuserID());
		assertEquals(cupcake_categoryID,recipe.getcategoryID());

	}
}