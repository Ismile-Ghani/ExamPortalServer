package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.User;
import com.exam.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception
	{
		return this.userservice.createUser(user, null);
	}
	
	

}
