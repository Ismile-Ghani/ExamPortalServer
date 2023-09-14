package com.exam.services.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		
		User local = this.userrepo.findByUsername(user.getUsername());
		if(local != null)
		{
			System.out.println("User already there");
			throw new Exception("User already present!!!");
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
	
	

}
