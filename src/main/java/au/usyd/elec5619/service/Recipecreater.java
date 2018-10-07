package au.usyd.elec5619.service;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import au.usyd.elec5619.domain.Recipe;
import au.usyd.elec5619.domain.Recipetest;


public interface Recipecreater extends Serializable{

	public List<Recipe> getRecipes();
	public String test();
	public void addrecipe(Recipetest recipetest);
	public String uploadpicture(MultipartFile file)throws Exception, IOException;

	
	
}