package com.rjxy.ex3;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.rjxy.bean.Order;
import com.rjxy.ex2.MybatisUtils;

public class OrderTest {
	@Test
	public  void getOrder(){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		
		String statement = "com.rjxy.ex3.orderMapper.getOrder";
		Order order = session.selectOne(statement,2);
		System.out.println(order);
	}
}
