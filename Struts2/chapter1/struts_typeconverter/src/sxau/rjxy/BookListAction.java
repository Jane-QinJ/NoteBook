package sxau.rjxy;

import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import domain.Book;

public class BookListAction extends ActionSupport{
	private List<Book> books; //没有使用泛型（generic）

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public String execute() {
		if(books==null || books.isEmpty()) {
			addActionError("请输入完整的书目信息");
			return INPUT;
		}else {
			System.out.println("添加的书目信息如下："); 
			Iterator<Book> it = books.iterator();
			while(it.hasNext()) {
				Book book = it.next();
				System.out.println("BookName"+book.getBookName());
				System.out.println("BookPrice"+book.getBookPrice());
				System.out.println("BookPublishDate"+book.getBookPublishDate());
				System.out.println("BookCount"+book.getBookCount());
				System.out.println("=================");
			}
			return SUCCESS;
		}
			
	}
}
