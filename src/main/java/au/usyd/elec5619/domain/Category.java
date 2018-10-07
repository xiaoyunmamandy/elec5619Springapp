package au.usyd.elec5619.domain;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Categories")
public class Category implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="categoryID", nullable=false,unique=true)
	private int categoryID;
	@Column(name="categoryName")
	private String categoryName;
	
	public Category() {
		super();
	}
	public Category(String categoryName) {
		super();
		this.categoryName = categoryName;
	}
	
	public int getcategoryID() {
		return categoryID;
	}
	public void setcategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	
	public String getcategoryName() {
		return categoryName;
	}
	public void setcategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
