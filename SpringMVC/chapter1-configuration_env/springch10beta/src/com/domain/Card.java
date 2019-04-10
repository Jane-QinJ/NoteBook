package com.domain;
//1.mysql
//2.bean实体类和字段同名
public class Card {
	private Integer id;
	//to be continued...
	private String name;
	private String tel;
	
	public Card(Integer id, String name, String tel) {
		
		this.id = id;
		this.name = name;
		this.tel = tel;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
