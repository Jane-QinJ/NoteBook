package com.rjxy.ex7;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.rjxy.ex2.MybatisUtils;

public class Test8 {
	@Test
	public void test8() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		
		String statement = "com.rjxy.ex7.userMapper.getCount";
		
		Map<String, Integer> parameterMap = new HashMap<String, Integer>();
		parameterMap.put("sex_id",0);
		parameterMap.put("user_count",-1);
		
		session.selectOne(statement,parameterMap);
		
		Integer result = parameterMap.get("user_count");
		System.out.println(result);
		session.close();
	}
}	
