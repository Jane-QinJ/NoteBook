package com.rjxy.ex6;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.rjxy.bean.ConditionUser;
import com.rjxy.bean.User;
import com.rjxy.ex2.MybatisUtils;

public class Test7 {
	@Test
	public void test7() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		
		String statement = "com.rjxy.ex6.userMapper.getUser";
		
		String name = null;
		ConditionUser parameter = new ConditionUser("%"+name+"%",13,18);
		List<User> userlist = session.selectList(statement,parameter);
		System.out.println(userlist);
	}
}
