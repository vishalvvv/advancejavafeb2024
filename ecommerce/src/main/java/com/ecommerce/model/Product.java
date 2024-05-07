package com.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="ecommerce_products")
public class Product {
	
	@Id @GeneratedValue
  private int productId;
	@Column(unique = true)
  private String name;
	@Column(unique = true)
  private String description;
	@Column
  private long price;
	@Column
  private int quantityAvailable;
	@Column
  private String category;
	@Column(unique = true)
  private String brand;
	@Column(unique = true)
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public long getPrice() {
	return price;
}
public void setPrice(long price) {
	this.price = price;
}
public int getQuantityAvailable() {
	return quantityAvailable;
}
public void setQuantityAvailable(int quantityAvailable) {
	this.quantityAvailable = quantityAvailable;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
  
  
	

}
