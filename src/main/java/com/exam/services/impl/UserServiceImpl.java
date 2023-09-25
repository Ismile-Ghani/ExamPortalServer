package com.exam.services.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.helper.UserFoundException;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;
import com.exam.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private RoleRepository rolerepo;

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		
		System.out.println("In Service Impl class");
		
		User local = this.userrepo.findByUsername(user.getUsername());
		if(local != null)
		{
			System.out.println("User already there");
			throw new UserFoundException("User already present!!!");
		}
		else {
			
			for(UserRole ur:userRoles)
			{
				this.rolerepo.save(ur.getRole());
			}
			user.getUserRole().addAll(userRoles);
			local = this.userrepo.save(user);
		}
		return local;
	}

	@Override
	
	public User getUser(String username) {
		return this.userrepo.findByUsername(username);
	}

	@Override
	public String deleteUser(String username) {
		
		this.userrepo.deleteByUsername(username);
		return "User with username" + username + "has been deleted";
	}
	
	

}
