package com.rjxy.bean;

import java.io.Serializable;

public class CUser implements Serializable{
	private int id;
	private String name;
	private int age;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public CUser(String name, int age,int id) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public CUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CUser [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	

}
