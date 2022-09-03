package com.nagarro.training.AdvancedJavaAssignment3.models;

import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
public class Products {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String title;
	int quantity;
	int size;
	@Lob
    @Column(columnDefinition="BLOB")
	byte[] image;
	
//	String productImage;
	public String getProductImage() {
    	String productImage = Base64.getEncoder().encodeToString(this.image);
		return productImage;
	}


	String user;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
}
