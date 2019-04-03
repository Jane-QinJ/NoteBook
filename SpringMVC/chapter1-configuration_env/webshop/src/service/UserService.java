package service;

import org.springframework.stereotype.Service;

import domain.User;



@Service
public class UserService {
	public boolean login(User user) {
		if("qin".equals(user.getUsername())&& "123".equals(user.getPassword())) {
			return true;
		}else {
			return false;
		}
	}
}