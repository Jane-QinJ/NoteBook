package service;



import domain.Book;



public interface CartService {
	
	//增加
	public void addBook(String id, Book book);
		
		//查询

		//修改

		//删除
		public void deleteBook(String id);
		
		public void clearBook();
		
		
		
		public double getTotalPrice();
		
		public void updateBook(String id, String quantity);
}
