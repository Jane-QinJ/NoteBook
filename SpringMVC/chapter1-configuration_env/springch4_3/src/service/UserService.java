package service;

import java.util.ArrayList;

import domain.User;

public interface UserService {
	//增加
	boolean addUser(User u);
	ArrayList<User> getUsers();
	
	//查询
	User getUser(int id);
	//修改
	void updateUser(int id, User user);
	//删除
	void del(int id);
}
