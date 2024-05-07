package com.crudapp.service;

import java.util.List;

import com.crud.utils.ActionResponse;
import com.crud.utils.EmailDetails;
import com.crudapp.model.User;

public interface UserService {
	 public ActionResponse register(User user);
	 public List<User> getUsers();
	 public ActionResponse deleteUser(long userId);
	 public ActionResponse updateUser(User user);
	 String sendSimpleMail(EmailDetails details);
}
