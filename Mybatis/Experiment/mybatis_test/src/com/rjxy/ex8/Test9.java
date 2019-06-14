package com.rjxy.ex8;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.rjxy.bean.CUser;
import com.rjxy.ex2.MybatisUtils;
public class Test9 {
	@Test
	public void testCacheOne() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		
		String statement = "com.rjxy.ex8.userMapper.getUser";
		CUser user = session.selectOne(statement,1);
		System.out.println(user);
		
		user = session.selectOne(statement,1);
		System.out.println(user);
		System.out.println("------------------");
//		1. 执行了session.clearCache
		session.clearCache();
		user = session.selectOne(statement,1);
		System.out.println(user);
		System.out.println("------");
		//2.执行CUD操作
		session.update("com.rjxy.ex8.userMapper.updateUser",new CUser("Tom",14,1));
		session.commit();
		
		user = session.selectOne(statement,1);
		System.out.println(user);
		
		System.out.println("--------");
		//3.不是同一个Session对象
		session.close();
		session = factory.openSession();
		
		user = session.selectOne(statement,1);
		System.out.println(user);
	}
}
