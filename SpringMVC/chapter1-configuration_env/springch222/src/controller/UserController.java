package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 * <input type="text" name="uname"> <br> <input
			type="password" name="upass"> <br> <input
			type="password" name="repass"> <br>
			
			形参
 */
@Controller
@RequestMapping("/user")
public class UserController {
//	1. 形参接收 
	@RequestMapping("/register")
	public String register(String uname, String upass, Model model) {
		//2.业务处理
		if("qin".equals((uname) )&& "123".equals(upass)) {
			//提交成功
			return "login";
		}else {
			//提交失败
//			3.存放
			model.addAttribute("uname",uname);
			model.addAttribute("upass",upass);
			model.addAttribute("error","提交失败");
//			4.跳转
			return "register";
		}
	}
}
