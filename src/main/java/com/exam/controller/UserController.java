package com.exam.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@PostMapping("/")
	public User createUsers(@RequestBody User user) throws Exception
	{
		UserRole ur = new UserRole();
		Role r = new Role();
		r.setRoleId(1);
		r.setRoleName("NORMAL");
		ur.setRole(r);
		ur.setUser(user);
		Set<UserRole> sr = new HashSet<UserRole>();
		sr.add(ur);
		
		user.setPassword(this.bcrypt.encode(user.getPassword()));
		
		
		return this.userservice.createUser(user,sr);
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username)
	{
		return this.userservice.getUser(username);
	}
	
	@DeleteMapping("/deleteUser/{username}")
	public String deleteUser(@PathVariable("username") String username)
	{
		return this.userservice.deleteUser(username);
	}

}
