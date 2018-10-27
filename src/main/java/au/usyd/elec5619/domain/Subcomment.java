package au.usyd.elec5619.domain;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class Subcomment implements Serializable{

	private int SubcommentID;
	private int userID;
	private String description;
	
	public Subcomment() {
		super();
	}
	
	public Subcomment(String description, int userID) {
		super();
		this.description = description;
		this.userID = userID;
	}
	
	
	public int getSubcommentID() {
		return SubcommentID;
	}
	public void setCommentID(int commentID) {
		this.SubcommentID = commentID;
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
	
	

	
}