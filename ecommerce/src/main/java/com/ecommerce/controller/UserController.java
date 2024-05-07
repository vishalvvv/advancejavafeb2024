package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.User;
import com.ecommerce.service.UserService;
import com.ecommerce.utils.Response;

@RequestMapping("/user")
@RestController
public class UserController {
	
	  @Autowired
	  UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<Response> register(@RequestBody User user) {
		ResponseEntity<Response> r = null;
		     Response response= userService.register(user);
		     if(response.isResult()) {
		    	 r = new ResponseEntity<Response>(response,HttpStatusCode.valueOf(200));
		     }
		     else{
		    	 new ResponseEntity<Response>(response,HttpStatusCode.valueOf(500)); 
		     }
		return r;
	}
	
	@PostMapping("/login")
	public ResponseEntity<Response> login(@RequestBody User user) {
		ResponseEntity<Response> r = null;
		  Response response   = userService.login(user);
		  if(response.isResult()) {
		    	 r = new ResponseEntity<Response>(response,HttpStatusCode.valueOf(200));
		     }
		     else{
		    	 new ResponseEntity<Response>(response,HttpStatusCode.valueOf(500)); 
		     }
		return r;
	}
	
	@PostMapping("/forgotPassword")
	public ResponseEntity<Response> forgotPassword(@RequestBody User user) {
		ResponseEntity<Response> r = null;
		     Response response= userService.forgotPassword(user);
		     if(response.isResult()) {
		    	 r = new ResponseEntity<Response>(response,HttpStatusCode.valueOf(200));
		     }
		     else{
		    	 new ResponseEntity<Response>(response,HttpStatusCode.valueOf(500)); 
		     }
		return r;
	}
	
	@PostMapping("/changePassword")
	public ResponseEntity<Response> changePassword(@RequestBody User user) {
		ResponseEntity<Response> r = null;
		     Response response= userService.changePassword(user);
		     if(response.isResult()) {
		    	 r = new ResponseEntity<Response>(response,HttpStatusCode.valueOf(200));
		     }
		     else{
		    	 new ResponseEntity<Response>(response,HttpStatusCode.valueOf(500)); 
		     }
		return r;
	}
	
	
}
