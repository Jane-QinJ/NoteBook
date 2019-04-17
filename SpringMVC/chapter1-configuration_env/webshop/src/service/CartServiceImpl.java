package service;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import org.springframework.stereotype.Service;

import domain.Book;
@Service
public class CartServiceImpl implements CartService{

private Hashtable<String, Book> ht = new Hashtable<>(); 
	
	public void addBook(String id, Book book) {
		if(ht.containsKey(id)) { //判断id是否包含
			Book book_bought = ht.get(id); //已经购买的书
			book_bought.setQuantity(book_bought.getQuantity()+1);//加一
			
			
		}else {
			ht.put(id, book); 
		}
	}
	
	public void deleteBook(String id) {
		Book book_bought = ht.get(id);
		if(book_bought.getQuantity()>1) {
			book_bought.setQuantity(book_bought.getQuantity()-1);
		}else if(book_bought.getQuantity() == 1) {
			ht.remove(id);
		}
	}
	
	public void clearBook() {
		ht.clear();
	}
	
	//
	public ArrayList<Book> showCart(){
		ArrayList<Book> booklist = new ArrayList<Book>();
		
//		Iterator<String> iterator = ht.keySet().iterator();   //键值迭代  也就是id
//		
//		while(iterator.hasNext()) {
//			String id = (String)iterator.next(); //用迭代器迭代所有id
//			Book book = ht.get(id); //将id放入book集合
//			booklist.add(book);   
//		}
		//枚举
		Enumeration<Book> elements = ht.elements();
		while (elements.hasMoreElements()) {
			Book book = (Book) elements.nextElement();
			booklist.add(book);
		}
		return booklist;
	}
	
	public double getTotalPrice() {
		double totalPrice = 0;
		Enumeration<Book> e = ht.elements();  //返回遍历值
		while(e.hasMoreElements()) {
			Book book = e.nextElement();  //
			totalPrice += book.getPrice()*book.getQuantity();
		}
		return totalPrice;
	}

	//更新书本数量
	public void updateBook(String id, String quantity) {
		Book book = ht.get(id); //获得书对象
		book.setQuantity(Integer.parseInt(quantity)); //更新书的数量
	}

}
