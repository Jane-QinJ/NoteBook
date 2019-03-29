package service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import domain.User;

@Service
public class UserServiceImpl implements UserService{
	//使用静态集合变量users模拟数据库
	private static ArrayList<User> users = new ArrayList<User>();
	@Override
	public boolean addUser(User u) {
		// TODO Auto-generated method stub
		if(!"IT民工".equals(u.getCarrer())) {//不允许添加 IT民工
			users.add(u);
			return true;}
		return false;
	}
		
	@Override
	public ArrayList<User> getUsers() {
		// TODO Auto-generated method stub
		return users;
	}
	
	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		
		return users.get(id); //查询某一个
	}

	@Override
	public void updateUser(int id, User user) {
		// TODO Auto-generated method stub
		users.set(id, user); //修改某一个
	}

	@Override
	public void del(int id) {
		// TODO Auto-generated method stub
		users.remove(id); //删除某一个
	}
	
	
}
