package au.usyd.elec5619.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Collection")
public class Collection implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="collectionID", nullable=false, unique=true)
	private int collectionID;
	@Column(name="recipeID")
	private int recipeID;
	@Column(name="userID")
	private int userID;
	
	public Collection() {
		super();
	}
	public Collection(int recipeID, int userID) {
		super();
		this.recipeID=recipeID;
		this.userID=userID;
	}
	public int getCollectionID() {
		return collectionID;
	}
	public void setCollectionID(int collectionID) {
		this.collectionID = collectionID;
	}
	public int getRecipeID() {
		return recipeID;
	}
	public void setRecipeID(int recipeID) {
		this.recipeID = recipeID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}

}
