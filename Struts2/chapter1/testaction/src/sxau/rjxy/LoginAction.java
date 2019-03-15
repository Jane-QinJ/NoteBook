package sxau.rjxy;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import sxau.rjxy.model.User;

/*
 * 3.模型驱动
 * 实现ModelDriven接口
 */
public class LoginAction implements Action{


	public String execute() {
		return SUCCESS; //常量，值为success
	}

}
