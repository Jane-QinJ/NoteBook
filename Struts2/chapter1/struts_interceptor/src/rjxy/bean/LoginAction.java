package rjxy.bean;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("a user added");
		System.out.println(user.getName()+"---"+user.getPwd());
		return "success";
	}
	
}
