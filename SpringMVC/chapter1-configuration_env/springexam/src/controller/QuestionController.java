package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Question;

import service.QuestionService;

@Controller
@RequestMapping("/test")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	@RequestMapping(value="/input")
	public String inputUser(Model model) {
		model.addAttribute("question", new Question());
		return "examAdd";
		
	}
	
	
	@RequestMapping(value="/save")
	public String addUser(@ModelAttribute Question question, Model model) {
		if(questionService.addUser(question)) {
			return "redirect:/test/list";
		}else {
			return "examAdd";
			
		}
	}
	
	
	@RequestMapping(value="/list")
	public String listUsers(Model model) {
		List<Question> questions = questionService.getPaper();
		model.addAttribute("juanzi",questions);
		return "examList";
	}
}
