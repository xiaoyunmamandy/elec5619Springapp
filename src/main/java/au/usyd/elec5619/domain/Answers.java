package au.usyd.elec5619.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Answers")
public class Answers implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="answerID", nullable = false, unique=true)
	private int answerID;
	@Column(name="subqa")
	private ArrayList<SubQA> sub;
	@Column(name="questionID",nullable = false)
	private int questionID;
	@Column(name="parentID")
	private int parentID;
	@Column(name="description")
    private String description;
	@Column(name="acceptence")
	private boolean acceptence;
	@Column(name="userId")
	private int userId;
	@Column(name="userName")
	private String userName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Answers() {
		super();
	}
	
	public Answers(int questionID, int parentID, String description, boolean acceptence, int userId) {
		super();
		this.questionID = questionID;
		this.parentID=parentID;
		this.description = description;
		this.acceptence = acceptence;
		this.userId = userId;
	}
	public Answers(int questionID, int parentID, String description, boolean acceptence, int userId, ArrayList<SubQA> sub, String userName) {
		super();
		this.questionID = questionID;
		this.parentID=parentID;
		this.description = description;
		this.acceptence = acceptence;
		this.userId = userId;
		this.sub = sub;
		this.userName = userName;
	}
	
	public int getAnswerId() {
        return answerID;
    }
	
	public void setAnswreId(int answerID) {
        this.answerID = answerID;
    }
	
	public int getQuestionId() {
        return questionID;
    }
	
	public void setQuestionId(int questionID) {
        this.questionID = questionID;
    }
    
	public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
	public boolean getAcceptence() {
        return acceptence;
    }
    
    public void setAcceptence(boolean acceptence) {
        this.acceptence = acceptence;
    }
    
	public int getUserId() {
        return userId;
    }
	
	public void setUserId(int userId) {
        this.userId = userId;
    }
	
	public ArrayList<SubQA> getSub() {
        return sub;
    }
	
	public void addSub(SubQA sub) {
        this.sub.add(sub);
    }
	
}