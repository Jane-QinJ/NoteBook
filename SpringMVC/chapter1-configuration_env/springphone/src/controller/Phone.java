package controller;

public class Phone {
//    手机名称：<form:input path="phone_name" />
//    价格：<form:input path="price" />
//    库存：<form:input path="stock" />
	private String phone_name;
	private double price;
	private int stock;
	public String getPhone_name() {
		return phone_name;
	}
	public void setPhone_name(String phone_name) {
		this.phone_name = phone_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

}
