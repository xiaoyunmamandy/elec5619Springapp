package au.usyd.elec5619.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class SubQA implements Serializable {
    private String description;
	private int userId;
	private String userName;


	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public SubQA() {
		super();
	}
	public SubQA(String description, int userId, String userName) {
		super();
		this.description = description;
		this.userId = userId;
		this.userName = userName;
	}
	
	public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
	public int getUserId() {
        return userId;
    }
	
	public void setUserId(int userId) {
        this.userId = userId;
    }
    
}