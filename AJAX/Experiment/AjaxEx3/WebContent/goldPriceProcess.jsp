<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


	<%
		String[] city = request.getParameterValues("city");
		String res = "[";
		System.out.println(city[0]);
		System.out.println((int)(Math.random()*1000+500));
		//out.println("[{'price':'"+(int)(Math.random()*1000+500)+"'},{'price':'"+(int)(Math.random()*1000+500)+"'},{'price':'"+(int)(Math.random()*1000+500)+"'}]");
		
		for(int i = 0; i<city.length;i++){
			//city数组最后一个元素之前，结尾用'}'，代表还有元素'
			if(i<city.length-1){ 
				res += "{'price':"+(int)(Math.random()*1000+500)+"},";
				//city最后一个元素，用']' ， 代表json结束
			}else{
				res += "{'price':"+(int)(Math.random()*1000+500)+"}]";
			
			}
		}
		out.println(res);
	%>
