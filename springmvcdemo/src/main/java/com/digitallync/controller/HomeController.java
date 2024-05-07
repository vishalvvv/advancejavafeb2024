package com.digitallync.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.digitallync.model.User;

@Controller
public class HomeController {
	
	@GetMapping(value="/home")
	public String homePage() {
		System.out.println("home page called");
		return "home";
	}
	
	@GetMapping(value="/login")
	public String login(Model model) {
		System.out.println("login page called");
		model.addAttribute("user",new User());
		return "login";
	}
	
	@PostMapping("/authenticate")
	public String authenticate(@ModelAttribute("user") User user,Model model) {
	
	String viewPage = "";
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		
		if(user.getUsername().contentEquals("vishal") && user.getPassword().contentEquals("vishal123")) {
		viewPage = "success";
		model.addAttribute("username",user.getUsername());
	}
	else {
		viewPage = "login";
		model.addAttribute("message","username / password incorrect!");
	}
	
	return viewPage;
	
}
}
