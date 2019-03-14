package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {
	@RequestMapping("/login")
	public String login() {
		return "forward:/index/isLogin";
	}
	@RequestMapping("/isLogin")
	public String isLogin() {
		return "redirect:/index/isRegister";
	}
	@RequestMapping("/isRegister")
	public String isRegister() {
		return "register";
	}
}
