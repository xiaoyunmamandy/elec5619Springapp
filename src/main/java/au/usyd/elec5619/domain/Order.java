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

@Entity
@Table(name="orders")
public class Order implements Serializable{
	
	@Id  
	@GeneratedValue
	@Column(name="Id")
	private long id;
	@Column(name="UserID")
	private long userid;
	@Column(name="Address")
	private String address;
	@Column(name="Contact")
	private int contact;
	@Column(name="Postcode")
	private int postcode;
	@Column(name="Country")
	private String country;
	@Column(name="Amount")
	private int amount;
	@Column(name="ProductID")
	private long productID;
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public int getPostcode() {
		return postcode;
	}
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public long getProductID() {
		return productID;
	}
	public void setProductID(long productID) {
		this.productID = productID;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", userid=" + userid + ", address=" + address + ", contact=" + contact
				+ ", postcode=" + postcode + ", country=" + country + ", amount=" + amount + ", productID=" + productID
				+ "]";
	}
	
}