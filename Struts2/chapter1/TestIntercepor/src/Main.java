//相当于ActionProxy
public class Main {
	public static void main(String[] args) {
		new ActionInvocation().invoke();  //初始化ActioinInvocation对象，添加两个拦截器
	}
}
