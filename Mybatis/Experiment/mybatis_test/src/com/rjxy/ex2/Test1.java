package com.rjxy.ex2;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.rjxy.bean.User;

public class Test1 {
	@Test
	public void testAdd() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		//默认是手动提交的
		//可以将factory.openSession(true);重载
		SqlSession session = factory.openSession();
		
		String statement = "com.rjxy.ex2.userMapper.insertUser";
		int insert = session.insert(statement, new User(-1,"Jane",21));	
		
		//提交
		session.commit();
		session.close();
		
		System.out.println(insert);

	}
	
	@Test
	public void testDelete() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		//默认是手动提交的
		//可以将factory.openSession(true);重载
		SqlSession session = factory.openSession(true);
		String statement1 = "com.rjxy.ex2.userMapper.deleteUser";
		int delete = session.insert(statement1, 6);
		System.out.println(delete);
	}
	
	@Test
	public void testSelect() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		//默认是手动提交的
		//可以将factory.openSession(true);重载
		SqlSession session = factory.openSession(true);
		String statement2 = "com.rjxy.ex2.userMapper.selectUser";
		User user = session.selectOne(statement2, 1);
		System.out.println(user);
	}
	
	@Test
	public void testSelectAll() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		//默认是手动提交的
		//可以将factory.openSession(true);重载
		SqlSession session = factory.openSession(true);
		String statement3 = "com.rjxy.ex2.userMapper.selectAllUsers";
		List<User> list = session.selectList(statement3);
		session.close();
		System.out.println(list);
	}
}
