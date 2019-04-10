package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InputController {
	@RequestMapping("/input")
	public String input(HttpServletRequest request,Model model) {
		//key-v, request, model
		String[] names = {"zhao","qian","sun"};
		request.setAttribute("name", names);
		
		String add[] = {"beijing","shanghai","guangzhou"};
		model.addAttribute("address",add);
		
		return "show";
		
	}
}
