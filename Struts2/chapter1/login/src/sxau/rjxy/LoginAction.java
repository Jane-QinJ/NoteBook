package sxau.rjxy;

public class LoginAction {
//	Username:<input type="text" name="username">
//	Password:<input type="password" name="password">
	private String name;
	private String password;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() {
		if("qin".equals(name) ) {
			return "success";
		}
		else {
			return "failure";
		}
	}
}
