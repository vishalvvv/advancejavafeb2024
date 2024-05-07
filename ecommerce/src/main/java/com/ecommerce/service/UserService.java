package com.ecommerce.service;

import com.ecommerce.model.User;
import com.ecommerce.utils.Response;

public interface UserService {
	 public Response register(User user);
	 public Response login(User user);
	  public Response forgotPassword(User user);
	  public Response changePassword(User user);
}
