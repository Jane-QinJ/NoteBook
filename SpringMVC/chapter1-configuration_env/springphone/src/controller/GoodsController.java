package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import service.GoodsService;

@Controller
@RequestMapping("/goods")

public class GoodsController {
	
	@Autowired
	GoodsService goodsService;

	@RequestMapping("/input")
	public String input(Model model) {
		model.addAttribute("phone", new Phone()); // 必须要有Phone对象 和表单modelAttribute保持一致
		return "addproduct"; // 打开表单页面
	}

	@RequestMapping("/save")
	public String save(@ModelAttribute Phone phone) // 和表单modelAttribute保持一致
//	@ModelAttribute 可以保留表单填写的数据
	{
		if (goodsService.add(phone)) {
			return "redirect:/goods/list"; 
		} else {
			return "addproduct";
		} // 回退 地址栏不变 goods/save
	}

	@RequestMapping("/list")
	public String list(Model model) {// 存多条数据
		List<Phone> array = goodsService.getdata();
		model.addAttribute("goodslist", array);
		return "productlist"; // 打开表格
	}
}
