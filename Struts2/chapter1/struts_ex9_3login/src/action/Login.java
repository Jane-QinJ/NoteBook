package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport implements SessionAware{
	private String message;
	private Map mySession;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public void setSession(Map<String,Object> mySession) {
		// TODO Auto-generated method stub
		this.mySession = mySession;
	}
	public String execute() {
		if(message == null || message.isEmpty()) {
			addActionError("请输入信息后提交!");
			return INPUT;
		}else {
			addActionMessage("您输入的信息是：" + message);
			mySession.put("loginFlag", "login");
			return SUCCESS;
		}
	}
	
	

}
