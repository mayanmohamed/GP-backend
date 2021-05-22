package com.luv2code.springboot.cruddemo.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

 

@Entity
@Table(name="product")
@JsonIdentityInfo(
		   generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Product {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_Id")
	int id;	
	
	
	@Column(name="product_Name")
	String productName;
	
	
	@Column(name="description")
	String description;
	
	
	@Column(name="price")
	double price;
	

	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="p_id")
	User   UserId;

	
	//@JsonBackReference
	@JsonIgnore
	public User getProductId() {
		return UserId;
	}


	public void setProductId(User productId) {
		UserId = productId;
	}


	public Product(String productName, String description, double price) {
		this.productName = productName;
		this.description = description;
		this.price = price;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}

	public Product() {
		
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", description=" + description + ", price="
				+ price + ", UserId=" + UserId + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
