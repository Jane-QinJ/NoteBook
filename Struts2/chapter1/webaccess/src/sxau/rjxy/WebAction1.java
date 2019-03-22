package sxau.rjxy;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class WebAction1 implements Action{
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext context = ActionContext.getContext();
		/*public Object get(Object key)
		 * ActionContext类没有提供类似getRequest()这样的方法来获取封装了HttpServletRequest的Map对象。
		 * 要得到Map对象，需要为get方法传递参数"request"*/
		Map request = (Map) context.get("request");
		Map session = context.getSession();
		Map application = context.getApplication();
		
//		在请求中放置信息
		request.put("r1", "r1");
//		在session中保存user对象
		session.put("user", "user");
//		在application中保存信息
		application.put("appkey", "value");
		return "success";
	}

}
