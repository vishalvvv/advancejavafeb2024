package com.firstapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/healthcheck")
	public String healthCheck() {
		return "App is running successfully";
	}

}
