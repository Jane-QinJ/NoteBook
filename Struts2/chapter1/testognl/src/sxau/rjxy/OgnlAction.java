package sxau.rjxy;

import com.opensymphony.xwork2.ActionSupport;

import sxau.rjxy.bean.Cat;
import sxau.rjxy.bean.*;

public class OgnlAction extends ActionSupport{
	private String name;
	private User user;
	private String password;
	private Cat cat;
	

	public OgnlAction() {
		password = "123456";
		cat = new Cat();
		
		
	}

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

	
	/*Action中添加访问cat的接口（get)*/
	public Cat getCat() {
		return cat;
	}

	public void setCat(Cat cat) {
		this.cat = cat;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	/*Action中的普通方法*/
	public String m() {
		return "actionMethod";
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		return super.execute();
	}
	
	
}
