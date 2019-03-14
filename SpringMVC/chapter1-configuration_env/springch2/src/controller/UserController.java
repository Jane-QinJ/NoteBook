package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.UserForm;

@Controller
@RequestMapping("/user")
public class UserController {
	//p24
	@RequestMapping("/reg_submit")
	public String register(UserForm user,Model model) {
		if("qin".equals(user.getUname())&&"123".equals(user.getUpwd())) {
			
			return "success"; //注册成功，请登录
		}
		else {
			//注册失败，表单回退
			model.addAttribute("uname",user.getUname());
			return "register";
		}
	}
}
