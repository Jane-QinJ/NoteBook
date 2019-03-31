package com.jane.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jane.dao.BookDao;
import com.util.db.DBUtils;

import domain.Book;

/**
 * BookDao的具体实现类
 * @author 秦佳
 *
 */
public class BookDaoImpl implements BookDao{
	
	@Override
	public ArrayList<Book> findAll() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Book book = null;
		ArrayList<Book> books = new ArrayList<Book>();
		String sql = "select id,price,name,description,author, pic from book";
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				book = new Book();
				book.setId(rs.getInt(1));
				book.setPrice(rs.getInt(2));
				book.setName(rs.getString(3));
				book.setInfo(rs.getString(4));
				book.setAuthor(rs.getString(5));
				book.setPic(rs.getString(6));
				books.add(book);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("查询所有数据失败");
		}finally {
			DBUtils.close(rs, ps, conn);
		}
		return books;
	}
	/*
	 * 查询所有数据
	 */
}