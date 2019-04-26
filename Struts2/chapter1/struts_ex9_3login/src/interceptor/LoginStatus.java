package interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.ActionSupport;
import action.Login;

public class LoginStatus extends AbstractInterceptor{
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Object action = invocation.getAction();
		/*
		 * 判断是否为登录请求:[IF1]{
		 * 1. 是登陆请求
			if true:则拦截器将控制转交给actioninvocation,执行Login action
			}
		   2.不是登录请求	
		 	if false: 取出session中存放的loginFlag值
		 	   判断是否为登录用户[IF2]{
		 	   if true已经登录过:(已经执行过Login,有loginFlag值)
		 	   	return invocation.invoke()
		 	  else未登录:
		 	     还未登录，return input登录
		 	  }
		 */
		if(action instanceof Login) {
			return invocation.invoke();
		}
		Map session = invocation.getInvocationContext().getSession();
		String login  = (String)session.get("loginFlag");
		if(login != null && login.equals("login")) {
			return invocation.invoke(); //已登录用户，返回success的result,返回视图
		}
		else {
			((ActionSupport)action).addActionMessage("来自拦截器的消息：您好没有登录，请先登录！");
			return "input";
		}

	}

}
