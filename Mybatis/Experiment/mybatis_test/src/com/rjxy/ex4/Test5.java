package com.rjxy.ex4;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import com.rjxy.bean.Classes;
import com.rjxy.ex2.MybatisUtils;

public class Test5{
	
	@Test
	public void getClasses(){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();

		String statement = "com.rjxy.ex4.classMapper.getClass";

		Classes c = session.selectOne(statement,2);
		System.out.println(c);

		session.close();
	}
}
