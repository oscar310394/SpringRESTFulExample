package com.codeovm.dao;

import java.util.List;

import com.codeovm.model.User;

public interface UserDAO {

	public List<User> listAllUser();

	public void addUser(User user);

	public void updateUser(User user);

	public void delete(User user);

	public User findUserById(User user);
}
