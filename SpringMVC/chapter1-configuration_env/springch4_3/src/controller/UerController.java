package controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.User;
import service.UserService;

@Controller
@RequestMapping("/user")
public class UerController {
	
	@Autowired
	private UserService userService;
	public void setform(Model model) {
		HashMap<String, String> hobbys = new HashMap<String,String>();
		hobbys.put("篮球", "basketball");
		hobbys.put("乒乓球", "pingpong");
		hobbys.put("电玩", "computer games");
		hobbys.put("游泳", "swimming");
		
//		model.addAttribute("user", new User()); 出错，每次都新建一个user，回退无法保存数据
		model.addAttribute("hobbys",hobbys);
		model.addAttribute("carrers",new String[] {"teacher","student","coding remover","IT民工","others"});
		model.addAttribute("houseRegisters", new String[] {"Beijing","ShangHai","Guangzhou","Shenzhen","others"});
	}
	@RequestMapping(value="/input")
	public String inputUser(Model model) {
		model.addAttribute("user", new User());
		setform(model);
		return "userAdd";
		
	}
	//输出表单，展示某一条就数据
	//user/select?id=1
	//user/select?id=0
		@RequestMapping(value="/select")
		public String update(@ModelAttribute User user,Integer id,Model model) {
			//修改某个数据
			model.addAttribute("users",userService.getUsers());
			model.addAttribute("id",id);
			setform(model);
			return "userUpdate"; //打开修改表单
		}
	
	@RequestMapping(value="/save")
	public String addUser(@ModelAttribute User user, Model model) {
		if(userService.addUser(user)) {
			return "redirect:/user/list";
		}else {
			setform(model);
			return "userAdd";
			
		}
	}
	
	
	//修改表单，点提交。修改某一个
	@RequestMapping(value="/update")
	public String updateUser(@ModelAttribute User user,Model model, int id) {
		userService.updateUser(id, user); //arraylist set方法
		return "redirect:/user/list";
	}
	
	//user/del?id=1
	@RequestMapping(value="/del")
	public String del(int id) {
		userService.del(id);
		return "redirect:/user/list";
	}
	
	@RequestMapping(value="/list")
	public String listUsers(Model model) {
		List<User> users = userService.getUsers();
		model.addAttribute("users",users);
		return "userList";
	}
}
