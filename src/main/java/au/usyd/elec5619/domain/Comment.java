package au.usyd.elec5619.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Comment")
public class Comment implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="commentID", nullable=false,unique=true)
	private int commentID;
	@Column(name="userID", nullable=false)
	private int userID;
	
	@Column(name="description", nullable=false,unique=true)
	private String description;
	@Column(name="recipeID", nullable=false)
	private int recipeID;
	
	@Column(name="Subcomment",nullable=false)
	private ArrayList<Subcomment> subcomment;
	@Column(name="userName", nullable=false,unique=true)
	private String userName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Comment() {
		super();
	}
	
	public Comment(int userID, String description, int recipeID, ArrayList<Subcomment> sub,String userName) {
		super();
		this.userID = userID;
		this.description = description;
		this.recipeID = recipeID;
		this.subcomment = sub;
		this.userName = userName;
	}
	
	public int getCommentID() {
		return commentID;
	}
	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRecipeID() {
		return recipeID;
	}
	public void setRecipeID(int recipeID) {
		this.recipeID = recipeID;
	}
	
	public ArrayList<Subcomment> getSub() {
        return subcomment;
    }
	
	public void addSub(Subcomment sub) {
        this.subcomment.add(sub);
    }
	

	
}