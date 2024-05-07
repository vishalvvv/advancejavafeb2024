package com.usermgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usermgt.dao.UserDAO;
import com.usermgt.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	@Transactional
	public String createUser(User user) {
		  // Middleware logic
		return  userDAO.createUser(user);	
	}

     @Transactional
	public List getAllUsers() {
		// TODO Auto-generated method stub
		return userDAO.getAllUsers();
	}

     @Transactional
	public boolean deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		return userDAO.deleteUser(userId);
	}

	@Transactional
	public User getUserById(long userId) {
		// TODO Auto-generated method stub
		return userDAO.getUserById(userId);
	}

	@Transactional
	public boolean updateUser(User user) {
		return userDAO.updateUser(user);
		
	}

}
