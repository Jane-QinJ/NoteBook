package service;

import org.springframework.stereotype.Service;

import domain.UserForm;

//p34, interface implements
// class
@Service
public class UserService {
	public boolean login(UserForm user) {
		if("qin".equals((user.getUname()) )&& "123".equals(user.getUpass())) {
			return true;
		}else {
			return false;
		}
	}
}
