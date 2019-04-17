package controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Food;
import service.FoodService;

@Controller
@RequestMapping("/food")
public class FoodController {
	@RequestMapping("/input")
	public String inputFood(Model model) {
		model.addAttribute("food", new Food());
		return "addfood";
	}

	@Autowired
	private FoodService foodService;

	@RequestMapping("/save")
	public String addFood(@ModelAttribute Food food) {
		if (foodService.add(food)) {
			return "redirect:/food/list";
		} else {
			return "addfood";
		}
	}

	@RequestMapping("/list")
	public String listfood(Model model) {
		ArrayList<Food> foodlist = foodService.getFoodlist();
		model.addAttribute("foodlist", foodlist);
		return "foodlist";
	}
}