package sxau.rjxy;

import com.opensymphony.xwork2.ActionSupport;

import domain.Book;

public class BookAction extends ActionSupport{
	private Book book;  //表单中的String经Action处理后，会自动转换类型存入bean对象
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String execute() {
		if((book == null) || book.getBookName().isEmpty()){
			addActionError("请输入完整的书目信息"); //错误信息处理
			return INPUT;
		}
		else {
			System.out.println("添加的书目信息如下：");
			System.out.println("书名："+book.getBookName());
			System.out.println("单价："+book.getBookPrice());
			System.out.println("出版日期："+book.getBookPublishDate());
			System.out.println("数量："+book.getBookCount());
			
			return SUCCESS;
		}
	}
}
