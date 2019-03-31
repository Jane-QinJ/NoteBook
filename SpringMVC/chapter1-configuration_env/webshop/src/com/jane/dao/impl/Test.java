package com.jane.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import domain.Book;

public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		BookDaoImpl bookImpl = new BookDaoImpl();
		ArrayList<Book> booklist = new ArrayList<Book>();
		booklist = bookImpl.findAll();
		System.out.println(booklist);
	}

}
