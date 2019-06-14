package com.rjxy.ex8;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.rjxy.bean.CUser;
import com.rjxy.ex2.MybatisUtils;



public class Test10 {
	@Test
	public void testCache2() {
		String statement = "com.rjxy.ex8.userMapper.getUser";
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		CUser user = session.selectOne(statement, 1);
		session.commit();
		System.out.println("user="+user);	
		
		SqlSession session2 = factory.openSession();
		
		user = session2.selectOne(statement, 1);
		session.commit();
		System.out.println("user2="+user);

	}
}
