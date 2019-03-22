package sxau.rjxy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class WebAction3 extends ActionSupport{

	HttpServletRequest request;
	HttpSession session;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		request = ServletActionContext.getRequest();
	/*ServletActionContext类并没有给出直接得到HttpSession对象的方法
	 * HttpSession对象可以通过HttpServletRequest对象来得到*/
		session = request.getSession(true);
		
		request.setAttribute("r1", "r1");
		session.setAttribute("session", "session");
		return super.execute();
	}
	
}
