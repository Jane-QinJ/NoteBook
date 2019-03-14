package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.UserForm;
import service.UserService;
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
//	@RequestParam 必须找到请求参数 如果没有就报错
	//只要指定了某个表单组建的name,可以不同名   @RequestParam("uname") String notname
	
	//消除 new UserService()
	//自动填充 依赖注入 Spring IOC
	@Autowired
	public UserService userService;
	//p37 第10章，执行公共功能，判断是否已登录 Spring AOP
	@RequestMapping("/register")
	//依赖注入方式
	public String register(@ModelAttribute("user") UserForm user) {
		if(userService.login(user)) {
			return "login";
		}else {
			return "register";
		}
		
	}
//	public String register(String uname, String upass, String repass,Model model) {
//		//2.业务处理
//		if("qin".equals((uname) )&& "123".equals(upass)) {
//			//提交成功
//			return "login";
//		}else {
//			//提交失败
////			3.存放
//			model.addAttribute("uname",uname); String
//			model.addAttribute("upass",upass);
	                      //   "user"user
//			model.addAttribute("error","提交失败");
//			//model.addAttribute("user","实体BEAN");
////			4.跳转
//			return "register";
//		}
//		//@ModelAttribute和model.addAttribute();功能相同
//		//心得体会@ModelAttribute 加在String参数上无效， 实体javabean上可以
//	}
}
