package com.yzk.student.model;

public class Kecheng {
	private int id;
	private String name;
	public Kecheng(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Kecheng() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Kecheng [id=" + id + ", name=" + name + "]";
	}
	public int getId() {
		return id;
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
	
}
