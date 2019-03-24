package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import domain.Pyq;

//注解为一个服务
@Service
public class PyqService {
	List<Pyq> pyqlist = new ArrayList<Pyq>(); 
	public boolean add(Pyq pyq) {
		if(!pyq.getAuthor().equals("qin")) {
			pyqlist.add(pyq);
			return true;
		}
		else {
			return false;
		}
	}
	public List<Pyq> getdata(){
		return pyqlist;
	}
}
