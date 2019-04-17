package controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Book;
import domain.Cart;


@Controller
@RequestMapping("/book")
public class CartController {
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request, HttpServletResponse response,HttpSession session,Book book) {
		String id = request.getParameter("id");  
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String quantity = request.getParameter("quantity");
		Cart cart = (Cart)request.getSession().getAttribute("cart"); //获得session，域对象
		
		
		book.setId(Integer.parseInt(id));
		book.setName(name);
		book.setPrice(Double.parseDouble(price));
		book.setQuantity(Integer.parseInt(quantity));
		
		cart.addBook(id, book); //加到购物车中
		Double totalPrice = cart.getTotalPrice();
		
		request.setAttribute("booklist", cart.showCart());   //传书的列表
		request.setAttribute("totalPrice", cart.getTotalPrice());		//请求域中  double转化为了一个对象Double（装箱）
		
		return "showCart";
		
	}
}
