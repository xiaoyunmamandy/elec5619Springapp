package au.usyd.elec5619.domain;

import junit.framework.TestCase;

public class RecipeTest extends TestCase{
	private Recipe recipe;
	
	protected void setUp() throws Exception{
		recipe = new Recipe();
	}
	
	public void testSetAndGetRecipeID() {
		int testRecipeID = 100;
		assertNull(recipe.getuserID());
		recipe.setrecipeID(testRecipeID);
		assertEquals(testRecipeID, recipe.getrecipeID());
	}
	
	public void testSetandGetrecipeName() {
		String testrecipeName = "muffin";
		assertNull(recipe.getrecipeName());
		recipe.setrecipeName(testrecipeName);
		assertEquals(testrecipeName, recipe.getrecipeName());
	}
	
	public void testSetandGetcookTime() {
		int testcookTime = 100;
		assertNull(recipe.getcookTime());
		recipe.setcookTime(testcookTime);
		assertEquals(testcookTime, recipe.getcookTime(),0);
	}
	
//	public void testSetandGetdishImg() {
//		String testdishImg = "xxxx";
//		recipe.setdishImg(testdishImg);
//		assertEquals(testdishImg, recipe.getdishImg());
//	}
	
	public void testSetandGetservepeopleNo() {
		int testservepeopleNo = 4;
		assertNull(recipe.getservepeopleno());
		recipe.setservepeopleno(testservepeopleNo);
		assertEquals(testservepeopleNo, recipe.getservepeopleno(),0);
	}
	
	public void testSetandGettips() {
		String testtips = "please preheat the oven to 180";
		assertNull(recipe.gettips());
		recipe.settips(testtips);
		assertEquals(testtips, recipe.gettips());
	}
	
	public void testSetandGetcategoryID() {
		int testcategoryID = 1;
		assertNull(recipe.getcategoryID());
		recipe.setcategoryID(testcategoryID);
		assertEquals(testcategoryID, recipe.getcategoryID(),0);
	}
	
	public void testSetandGetuserID() {
		int testuserID = 1;
		assertNull(recipe.getuserID());
		recipe.setuserID(testuserID);
		assertEquals(testuserID, recipe.getuserID(),0);
	}
}