package com.yzk.student.model;

public class Chengji {
	private int id;
	private int sid;
	private String kname;
	private String fenshu;
	private String teacher;
	public Chengji() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Chengji(int id, int sid, String kname, String fenshu, String teacher) {
		super();
		this.id = id;
		this.sid = sid;
		this.kname = kname;
		this.fenshu = fenshu;
		this.teacher = teacher;
	}
	@Override
	public String toString() {
		return "Chengji [id=" + id + ", sid=" + sid + ", kname=" + kname + ", fenshu=" + fenshu + ", teacher=" + teacher
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getKname() {
		return kname;
	}
	public void setKname(String kname) {
		this.kname = kname;
	}
	public String getFenshu() {
		return fenshu;
	}
	public void setFenshu(String fenshu) {
		this.fenshu = fenshu;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
}
