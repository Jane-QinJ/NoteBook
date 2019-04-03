package domain;
/**
 * 领域模型，表示是对它进行增删改查。
 */

public class Book {

	private int id;			//book id
	private Double price;	//book price
	private String name;	//book's name
	private String info;   //book's info
	private String author; //book's author
	private int quantity = 1;  //book's quantity
	private String pic;      //book's picture
	

	public Book() {
		
	}
	public Book(int id, double price, String name, String info) {
		this.id = id;
		this.price = price;
		this.name = name;
		this.info = info;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Book[id "+id+",price"+price+",name "+name+",description "+info+",pic "+pic;
	}
}
