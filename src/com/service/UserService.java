package com.service;

import java.util.List;

import com.model.User;

public interface UserService {

	String loginCheck(User user);

	List<User> getAllUsers();

	String addUser(String userName, String password);

	boolean update(String id, String userName, String password);

	void deleteUser(String id);

}
