package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Pyq;
import service.PyqService;

@Controller
@RequestMapping("/pyq")
public class PyqController {
	//将服务依赖注入属性pyqService
	@Autowired
	public PyqService pyqService;
	
	@RequestMapping("/input")
	public String input(Model model) {
		//必须要有Pyq对象 和表单的modelAttribute(也就是绑定的javabean)保持一致
		model.addAttribute("pyq", new Pyq());
		return "addpyq";
	}
	@RequestMapping("/save")
	public String save(@ModelAttribute Pyq pyq) {
		if(pyqService.add(pyq)) {
			return "redirect:/pyq/list";
		}
		else{
			return "addpyq";
		}
	}
	@RequestMapping("/list")
	public String list(Model model) { //存多条数据
		List<Pyq> array = pyqService.getdata();
		model.addAttribute("pyqlist", array);
		return "pyqlist"; //打开表格
		
	}
	
}
