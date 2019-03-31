package controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.User;

import service.UserService;

@Controller
@RequestMapping("/user")
public class ValidateController {
	@Autowired
	private UserService userService;
	@RequestMapping("/validate")
	public String validate(@ModelAttribute User user) {
		if(userService.login(user)) {
			return "welcome";
		}else {
			return "login.jsp";
		}
		
	}
	
}
