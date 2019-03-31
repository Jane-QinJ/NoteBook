package domain;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;


public class Cart {
	private Hashtable<String, Book> ht = new Hashtable<>(); 
	/*add commodity*/
	public void addBook(String id, Book book) {
		/*purchase one that already in the cart*/
		if(ht.containsKey(id)) { 
			Book book_bought = ht.get(id); 
			book_bought.setQuantity(book_bought.getQuantity()+1);
			
			
		}else {
			ht.put(id, book); 
		}
	}
	
	/*delete commodity*/
	public void deleteBook(String id) {
		Book book_bought = ht.get(id);
		if(book_bought.getQuantity()>1) {
			book_bought.setQuantity(book_bought.getQuantity()-1);
		}else if(book_bought.getQuantity() == 1) {
			ht.remove(id);
		}
	}
	
	/*clear shopping cart*/
	public void clearBook() {
		ht.clear();
	}
	
	//show bought shopping cart
	public ArrayList<Book> showCart(){
		ArrayList<Book> booklist = new ArrayList<Book>();
		
//		Iterator<String> iterator = ht.keySet().iterator();   
//		
//		while(iterator.hasNext()) {
//			String id = (String)iterator.next(); 
//			Book book = ht.get(id); 
//			booklist.add(book);   
//		}
	
		Enumeration<Book> elements = ht.elements();
		while (elements.hasMoreElements()) {
			Book book = (Book) elements.nextElement();
			booklist.add(book);
		}
		return booklist;
	}
	
	/*calculate totalPrice*/
	public double getTotalPrice() {
		double totalPrice = 0;
		Enumeration<Book> e = ht.elements();   
		while(e.hasMoreElements()) {
			Book book = e.nextElement();  //
			totalPrice += book.getPrice()*book.getQuantity();
		}
		return totalPrice;
	}

	//update bought book's quantity
	public void updateBook(String id, String quantity) {
		Book book = ht.get(id); 
		book.setQuantity(Integer.parseInt(quantity)); 
	}
}
