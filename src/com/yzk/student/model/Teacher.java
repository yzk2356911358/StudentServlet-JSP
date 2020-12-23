package com.yzk.student.model;

public class Teacher {
	private int id;
	private String name;
	private String gender;
	private int age;
	private String kname;
	public Teacher(int id, String name, String gender, int age, String kname) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.kname = kname;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getKname() {
		return kname;
	}
	public void setKname(String kname) {
		this.kname = kname;
	}


}
