package au.usyd.elec5619.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Ingredients")
public class Ingredient implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ingredientID", nullable=false,unique=true)
	private int ingredientID;
	@Column(name="ingredientName")
	private String ingredientName;
	@Column(name="ingredientAmount")
	private String ingredientAmount;
	
	public Ingredient() {
		super();
	}
	public Ingredient(String ingredientName, String ingredientAmount) {
		this.ingredientName = ingredientName;
		this.ingredientAmount = ingredientAmount;
	}
	public int getIngredientID() {
		return ingredientID;
	}
	public void setIngredientID(int ingredientID) {
		this.ingredientID = ingredientID;
	}
	public String getIngredientName() {
		return ingredientName;
	}
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}
	public String getIngredientAmount() {
		return ingredientAmount;
	}
	public void setIngredientAmount(String ingredientAmount) {
		this.ingredientAmount = ingredientAmount;
	}

}
