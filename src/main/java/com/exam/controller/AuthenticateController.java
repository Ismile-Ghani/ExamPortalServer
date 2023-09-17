package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.config.JwtUtils;
import com.exam.model.JwtRequest;
import com.exam.model.Jwtresponse;
import com.exam.services.impl.UserDetailsServiceImpl;

@RestController
public class AuthenticateController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> getToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		System.out.println("From Authentication Controller: " + jwtRequest.getUsername() + "   "  +jwtRequest.getPassword());
		try {
			authenticated(jwtRequest.getUsername(), jwtRequest.getPassword());
		}catch(UsernameNotFoundException ex) {
			ex.printStackTrace();
			throw new Exception("User Not Found!!!");
		}
		UserDetails usrDetails = this.userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
		System.out.println("From Authentication Controller1: "+usrDetails.getUsername());
		String token = this.jwtUtils.generateToken(usrDetails);
		return ResponseEntity.ok(new Jwtresponse(token));
	}
	
	
	
	private void authenticated(String username,String password) throws Exception{
		
		UsernamePasswordAuthenticationToken usernamepasswordAuthentication = new UsernamePasswordAuthenticationToken(username, password);
		
		try {
			authenticationManager.authenticate(usernamepasswordAuthentication);
			
		}catch(DisabledException ex) {
			throw new Exception("User Disabled" +ex.getMessage());
		}catch(BadCredentialsException e1) {
			throw new BadCredentialsException("Bad Credentials");
		}
		
	}
	
	@ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

}
