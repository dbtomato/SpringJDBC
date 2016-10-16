package com.dao;

import java.util.List;

import com.model.User;

public interface UserDao {

	String findUserByUserName(String userName);

	List<User> findAllUsers();

	String addusers(String userName, String password);

	boolean upDate(String id, String userName, String password);

	void deleteUsers(String id);

}
