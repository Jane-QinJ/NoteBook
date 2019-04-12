package sxau.rjxy;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String execute() {
		if(username==null||username.equals("")) {
			return "login";
		}
		else {
			return "success";
		}
	}
}
