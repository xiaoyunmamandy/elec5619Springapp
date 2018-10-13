package au.usyd.elec5619.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Recipes")
public class Recipe implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="recipeID", nullable=false,unique=true)
	private int recipeID;
	@Column(name="recipeName")
	private String recipeName;
	@Column(name="cookTime")
	private int cookTime;
	@Column(name="servepeopleno")
	private int servepeopleno;
	@Column(name="dishImg")
	private String dishImg;
	@Column(name="tips")
	private String tips;
	@Column(name="categoryID")
	private int categoryID;
	@Column(name="userID")
	private int userID;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,targetEntity=Ingredient.class)  
    @JoinColumn(name="recipeID",nullable=false) 
	private List<Ingredient> ingredientlist;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,targetEntity=Step.class)  
    @JoinColumn(name="recipeID",nullable=false) 
	private List<Step> steplist;
	
	public Recipe() {
		super();
	}
	public Recipe(String recipeName, int cookTime, int servepeopleno, String dishImg,  String tips, int categoryID, int userID, List<Ingredient> ingredientlist, List<Step> steplist) {
		super();
		this.recipeID = recipeID;
		this.recipeName = recipeName;
		this.cookTime = cookTime;
		this.dishImg = dishImg;
		this.servepeopleno = servepeopleno;
		this.tips = tips;
		this.categoryID = categoryID;
		this.userID = userID;
		this.ingredientlist = ingredientlist;
		this.steplist = steplist;
	}
	public int getrecipeID() {
		return recipeID;
	}
	public void setrecipeID(int recipeID) {
		this.recipeID = recipeID;
	}
	
	public String getrecipeName() {
		return recipeName;
	}
	public void setrecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	
	public int getcookTime() {
		return cookTime;
	}
	public void setcookTime(int cookTime) {
		this.cookTime = cookTime;
	}
	
	public String getdishImg() {
		return dishImg;
	}
	public void setdishImg(String dishImg) {
		this.dishImg = dishImg;
	}
	
	public int getservepeopleno() {
		return servepeopleno;
	}
	public void setservepeopleno(int servepeopleno) {
		this.servepeopleno = servepeopleno;
	}
	
	public String gettips() {
		return tips;
	}
	public void settips(String tips) {
		this.tips = tips;
	}
	
	public int getcategoryID() {
		return categoryID;
	}
	public void setcategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	
	public int getuserID() {
		return userID;
	}
	public void setuserID(int userID) {
		this.userID = userID;
	}

}