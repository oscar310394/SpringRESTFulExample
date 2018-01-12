package com.codeovm.service;

import java.util.List;

import com.codeovm.model.User;

public interface UserService {

	public List<User> listAllUser();

	public void addUser(User user);

	public void updateUser(User user);

	public void delete(User user);

	public User findUserById(User user);
}
