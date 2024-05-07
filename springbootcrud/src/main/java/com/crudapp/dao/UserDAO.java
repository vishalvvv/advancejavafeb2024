package com.crudapp.dao;

import java.util.List;

import com.crud.utils.ActionResponse;
import com.crudapp.model.User;

public interface UserDAO {

	 public ActionResponse register(User user);
	 public List<User> getUsers();
	 public ActionResponse deleteUser(long userId);
	 public ActionResponse updateUser(User user);
	
}
