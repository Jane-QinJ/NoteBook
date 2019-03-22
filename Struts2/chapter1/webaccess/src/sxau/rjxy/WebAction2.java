package sxau.rjxy;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class WebAction2 extends ActionSupport implements RequestAware,SessionAware{
	private Map request;
	private Map session;
	private Map application;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
//		在请求中放置信息
		request.put("r1", "r1");
//		在session中保存user对象
		session.put("user", "user");
		return super.execute();
	}
	@Override
	public void setSession(Map session) {
		// TODO Auto-generated method stub
		this.session = session;
		}



	@Override
	public void setRequest(Map request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

}
