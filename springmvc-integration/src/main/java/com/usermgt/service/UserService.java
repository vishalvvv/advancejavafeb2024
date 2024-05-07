package com.usermgt.service;

import java.util.List;

import com.usermgt.model.User;

public interface UserService {
	 public String createUser(User user); 
	 public List getAllUsers();
	 public boolean deleteUser(Integer userId);
	 public User getUserById(long userId);
	 public boolean updateUser(User user);
}
