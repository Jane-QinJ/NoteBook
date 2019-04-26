import java.util.ArrayList;
import java.util.List;


public class ActionInvocation {
	List<Interceptor> interceptors = new ArrayList<Interceptor>(); //拦截器列表
	int index = -1;
	Action a = new Action();
	
	public ActionInvocation() {
		this.interceptors.add(new FirstInterceptor());
		this.interceptors.add(new SecondInterceptor());
		
	}
	
	public void invoke() {
		index ++;
		if(index >= this.interceptors.size()) {  //拦截器执行完毕
			a.execute();  //执行action
		}else {
			//拦截器还有，执行下一个拦截器
			this.interceptors.get(index).intercept(this); //调用intercept（）方法
		}
	}
}
