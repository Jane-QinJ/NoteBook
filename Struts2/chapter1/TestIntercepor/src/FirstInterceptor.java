
public class FirstInterceptor implements Interceptor {

	public void intercept(ActionInvocation invocation) {
		System.out.println(1);
		invocation.invoke();  //控制权返回到ActionInvocation
		System.out.println(-1);
	}

}
