package sxau.rjxy;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorld extends ActionSupport{
	private String message;
	//方法，要看返回值和参数
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String execute() {
		addActionMessage("HelloWorld! Message is:" + message);
		System.out.println("HelloWorld! Message is:" + message);
		return SUCCESS;
	}
}
