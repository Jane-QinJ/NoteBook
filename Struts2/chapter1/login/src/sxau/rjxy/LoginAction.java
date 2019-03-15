package sxau.rjxy;

import sxau.rjxy.model.User;

public class LoginAction {
//	Username:<input type="text" name="username">
//	Password:<input type="password" name="password">
	/*
	 * 属性驱动
	 */
//	private String name;
//	private String password;
//	
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
	/*
	 * 面向对象驱动
	 */
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() {
		if("qin".equals(user.getName())&&"123".equals(user.getPassword()) ) {
			return "success";
		}
		else {
			return "failure";
		}
	}
}
