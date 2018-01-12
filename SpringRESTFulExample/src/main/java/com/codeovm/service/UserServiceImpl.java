package com.codeovm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeovm.dao.UserDAO;
import com.codeovm.model.User;

@Service
public class UserServiceImpl implements UserService {

	UserDAO userDAO;

	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public List<User> listAllUser() {
		return userDAO.listAllUser();
	}

	public void addUser(User user) {
		userDAO.addUser(user);
	}

	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	public void delete(User user) {
		userDAO.delete(user);
	}

	public User findUserById(User user) {
		return userDAO.findUserById(user);
	}

}
