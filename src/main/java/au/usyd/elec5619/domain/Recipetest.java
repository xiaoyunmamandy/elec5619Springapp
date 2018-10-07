package au.usyd.elec5619.domain;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name="Recipestest")
public class Recipetest implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="recipeID", nullable=false,unique=true)
	private int recipeID;
	@Column(name="recipeName")
	private String recipeName;
	@Column(name="cookTime")
	private int cookTime;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,targetEntity=Step.class)  
    @JoinColumn(name="recipeID",nullable=false) 
	private List<Step> steplist;
	
	public Recipetest(String recipeName, int cookTime, List<Step> steplist) {
		super();
		this.recipeName = recipeName;
		this.cookTime = cookTime;
		this.steplist = steplist;
	}
	
//	public Recipetest() {
//		steplist = new ArrayList();
//	}
	public List<Step> getsteplist(){
		return steplist;
	}
	
	public void setsteplist(List<Step> steplist) {
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

}
