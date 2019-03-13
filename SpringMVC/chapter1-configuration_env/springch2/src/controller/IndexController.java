package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//模块Controller
@Controller
@RequestMapping("/index")
	
public class IndexController {
	//不需要父类和接口
	//两级的分类 /模块  /功能点
	@RequestMapping("/req_login")
	public String login(HttpSession session,
			HttpServletRequest request) {
		
		session.setAttribute("key1","Hello");
		request.setAttribute("key2", "Jane");
		//打开登录页面, return 网页文件名
		return "login";
	}
	@RequestMapping("/req_register")
	public String register(Model model) {
		
		//打开注册页面
		model.addAttribute("keym","注册的提示信息");
		return "register";
	}
	

}
