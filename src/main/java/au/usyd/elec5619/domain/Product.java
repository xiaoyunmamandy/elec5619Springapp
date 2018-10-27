package au.usyd.elec5619.domain;

//A POJO-driven approach means writing your message handling solution free of interfaces
//and use annotation to link it with interface

//Serialization turn the java object into ByteStream to persist it

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Product")
public class Product implements Serializable{
	
	@Id  
	@GeneratedValue
	@Column(name="Id")
	private long id;
	@Column(name="Name")
	private String Name;
	@Column(name="Amount")
	private int amount;
	@Column(name="Price")
	private Double price;
	@Column(name="ProductImg")
	private String productImg;
	//@Column(name="ProductImg")
	//private MultipartFile productImg;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getProductImg() {
		return productImg;
	}
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", Name=" + Name + ", amount=" + amount + ", price=" + price + ", productImg="
				+ productImg + "]";
	}

}