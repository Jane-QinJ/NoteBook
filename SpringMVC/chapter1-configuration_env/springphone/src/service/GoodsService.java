package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import controller.Phone;

@Service
public class GoodsService {
	List<Phone> phonelist = new ArrayList<Phone>();
	public boolean add(Phone phone) {
		if(!phone.getPhone_name().equals("vivo")) {
			phonelist.add(phone);
			return true;
		}else {
			return false;
		}
	
	}
	public List<Phone> getdata(){
		return phonelist;
	}
}
