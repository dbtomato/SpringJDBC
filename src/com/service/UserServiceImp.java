package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.model.User;
@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserDao userDao;

	public String loginCheck(User user) {
		// TODO Auto-generated method stub
		String result=userDao.findUserByUserName(user.getUserName());
		if(result.equals("ok"))
			return "ok";
		else
			return "error";
        
	}

	public List<User> getAllUsers() {
		List<User> users=userDao.findAllUsers();
		return users;

	}

	public String addUser(String userName,String password) {
		// TODO Auto-generated method stub
		String result=userDao.addusers(userName,password);
		return result;
	}

	public boolean update(String id, String userName, String password) {
		if(userDao.upDate(id, userName, password))
			return true;
			else return false;

	}

	public void deleteUser(String id) {
		userDao.deleteUsers(id);
	}



}
