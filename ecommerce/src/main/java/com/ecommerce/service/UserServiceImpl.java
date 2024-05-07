package com.ecommerce.service;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dao.UserDAO;
import com.ecommerce.model.User;
import com.ecommerce.utils.Response;

@Service
public class UserServiceImpl implements UserService {

	      @Autowired
	      UserDAO userDAO;
	
	@Transactional
	public Response register(User user) {
		Response response= null;
		   StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		    String encryptedPassword = passwordEncryptor.encryptPassword(user.getPassword());
		    user.setPassword(encryptedPassword);
		try {
			response = userDAO.register(user);
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
		return response;
		   
	}

	@Override
	public Response login(User user) {
		Response response= null;
		try {
			response = userDAO.login(user);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return response;
	}

	@Override
	public Response forgotPassword(User user) {
		Response response= null;
		try {
			response = userDAO.forgotPassword(user);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return response;	
	}

	@Override
	public Response changePassword(User user) {
		Response response= null;
		try {
			response = userDAO.changePassword(user);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return response;
		
	}

}
