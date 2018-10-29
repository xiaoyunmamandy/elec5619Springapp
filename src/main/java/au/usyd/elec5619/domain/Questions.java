package au.usyd.elec5619.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Questions")
public class Questions implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="questionID", nullable = false, unique=true)
	private int questionID;
	@Column(name="title")
	private String title;
	@Column(name="description")
    private String description;
	@Column(name="State")
	private boolean State;
	@Column(name="userId")
	private int userId;
	@Column(name="Worth")
	private int Worth;
	@Column(name="userName")
	private String userName;

	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Questions() {
		super();
	}
	public Questions(String title, String description, boolean state, int userId, int Worth,String userName) {
		super();
		this.title = title;
		this.description = description;
		this.State = state;
		this.userId = userId;
		this.Worth = Worth;
		this.userName = userName;
	}
	
	public int getQuestionId() {
        return questionID;
    }
	
	public void setQuestionId(int questionID) {
        this.questionID = questionID;
    }
    

	public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
	public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
	public boolean getState() {
        return State;
    }
    
    public void setState(boolean state) {
        this.State = state;
    }
    
	public int getUserId() {
        return userId;
    }
	
	public void setUserId(int userId) {
        this.userId = userId;
    }
	
	public int getWorth() {
        return Worth;
    }
	
	public void setWorth(int Worth) {
        this.Worth = Worth;
    }
    
}