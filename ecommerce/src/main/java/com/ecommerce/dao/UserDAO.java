package com.ecommerce.dao;

import com.ecommerce.model.User;
import com.ecommerce.utils.Response;

public interface UserDAO {

	     public Response register(User user);
	     public Response login(User user); 
	     public Response forgotPassword(User user);
	     public Response changePassword(User user);
	     
	     
	
}
