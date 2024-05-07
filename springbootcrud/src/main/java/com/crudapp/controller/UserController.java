package com.crudapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.utils.ActionResponse;
import com.crudapp.model.User;
import com.crudapp.service.UserService;

@RequestMapping("/user")
@RestController
public class UserController {

	  @Autowired
	  UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<ActionResponse> register(@RequestBody User user) {
		  System.out.println("I am in controller");
		   ActionResponse response =  userService.register(user);
		  return new ResponseEntity<ActionResponse>(response,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity getAllUsers(){
		List list = userService.getUsers();
		return new ResponseEntity(list, HttpStatus.OK);
	}
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<ActionResponse> delete(@PathVariable("userId") long userId) {
		  System.out.println("userId" + userId);   
		ActionResponse response =  userService.deleteUser(userId);
		  return new ResponseEntity<ActionResponse>(response,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ActionResponse> updateUser(@RequestBody User user) {
		 
		   ActionResponse response =  userService.updateUser(user);
		  return new ResponseEntity<ActionResponse>(response,HttpStatus.OK);
	}
	
	
	
	
	
}
