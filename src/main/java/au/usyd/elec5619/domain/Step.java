package au.usyd.elec5619.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Steps")
public class Step implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="stepsID", nullable=false,unique=true)
	private int stepsID;
	@Column(name="stepsno")
	private int stepsno;
	@Column(name="description")
	private String description;
	@Column(name="stepImg")
	private String stepImg;
	//private int recipeID;
	
	
	public Step() {
		super();
	}
	
	public Step(int stepsno, String description, String stepImg) {
		super();
		this.stepsno = stepsno;
		this.description = description;
		this.stepImg = stepImg;
	}
	
	public int getstepsID() {
		return stepsID;
	}
	
	public void setstepsID(int stepsID) {
		this.stepsID = stepsID;
	}

	public int getstepsno() {
		return stepsno;
	}
	
	public void setstepsno(int stepsno) {
		this.stepsno = stepsno;
	}
	
	public String getdescription() {
		return description;
	}
	
	public void setdescription(String description) {
		this.description = description;
	}
	
	public String getstepImg() {
		return stepImg;
	}
	
	public void setstepImg(String stepImg) {
		this.stepImg = stepImg;
	}
	
//	public int getrecipeID() {
//		return recipeID;
//	}
//	
//	public void setrecipeID(int recipeID) {
//		this.recipeID = recipeID;
//	}
}
