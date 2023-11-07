package com.dms;

public class Item {
	
	private int id;
	private String name ;
	private String description ;
	private int categoryId ;
	public int getId() {
		return id;
	}
	public Item(int id, String name, String description, int categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.categoryId = categoryId;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

}
