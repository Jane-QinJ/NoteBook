package sxau.rjxy;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor1 extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		//返回值Object,强转
		HelloWorld hw = (HelloWorld)invocation.getAction(); //查配置文件，获取Action对象 
		hw.addActionMessage("Calling MyInterceptor1"); //action继承ActionSupport,拥有的父类方法
		System.out.println("Calling MyInterceptor1");
		hw.addActionMessage("MyInterceptor1-1:ActionClass name is: "+ hw.getClass().getName());
		
		System.out.println("MyInterceptor1-1:ActionClass name is: "+ hw.getClass().getName());
		
		/*
		 * invocation.invoke()调用之前的代码将在Action执行之前执行
			invocation.invoke()调用之后的代码将在Action执行之后执行。
		 */
		String result = invocation.invoke(); //放行，转回ActionInvocation
		hw.addActionMessage("MyInterceptor1-2:Theresult is: "+result);
		System.out.println("MyInterceptor1-2:Theresult is: "+result);
		
		return result;
	}

}
