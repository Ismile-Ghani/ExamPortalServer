package com.exam.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exam.model.User;
import com.exam.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userepo;

	@Override
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = this.userepo.findByUsername(username);
		if(user == null)
		{
			throw new UsernameNotFoundException("User Not found with this user name!!!");
		}
		
		return user;
	}
	
	

}
