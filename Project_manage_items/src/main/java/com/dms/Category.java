package com.dms;

public class Category {

	//private Item item ;
	
	private int id;
	public int getId() {
		return id;
	}
	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	private String name ;
}
