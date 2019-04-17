package service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import domain.Food;

@Service
public class FoodService {
	ArrayList<Food> foodlist = new ArrayList<Food>();
	public boolean add(Food food) {
		if("noodles".equals(food.getName())) {
			foodlist.add(food);
			return true;
		}
		else {
			return false;
		}
	}
	public ArrayList<Food> getFoodlist(){
		return foodlist;
	}
}
