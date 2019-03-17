package sxau.rjxy;

import com.opensymphony.xwork2.ModelDriven;

import sxau.rjxy.model.User;

/*
 * 3.模型驱动
 * 实现ModelDriven接口
 */
public class LoginAction implements ModelDriven<User>{
//	Username:<input type="text" name="username">
//	Password:<input type="password" name="password">
	/*
	 * 1. 属性驱动
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
	 * 2.面向对象驱动
	 */
	private User user = new User();
	
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	public String execute() {
		if("qin".equals(user.getName())&&"123".equals(user.getPassword()) ) {
			return "success";
		}
		else {
			return "failure";
		}
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}
