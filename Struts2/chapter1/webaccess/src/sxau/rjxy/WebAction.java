package sxau.rjxy;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class WebAction extends ActionSupport implements ServletRequestAware{
	HttpServletRequest request;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
//		注入中的解耦方式
//		ActionContext.getContext("com.opensymphony.xwork2.dispatcher.HttpServletRequest");
		request.setAttribute("r1", "implements ServletRequestAware");
		return super.execute();
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
//		接口注入方式： 接口提供set方法，将HttpServletRequest对象注入到Action
		this.request = request;
	}
	
	
}
