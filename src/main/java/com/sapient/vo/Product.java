package com.sapient.vo;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Pojo class represt the Product Documet in mongo database.
 * @author pratikgupta
 *
 */
@Document
public class Product {

	@Indexed
	private String id;

	@NotEmpty(message ="Product name can not be empty")
	@Indexed(unique=true)
	private String name;
	
	@NotEmpty(message ="Product categotry can not be empty")
	private String category;
	
	private String description;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", type=" + category + "]";
	}
}
