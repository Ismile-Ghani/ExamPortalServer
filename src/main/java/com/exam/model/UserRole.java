package com.exam.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="userrole")
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long user_roleID;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;

	@ManyToOne(fetch = FetchType.EAGER)
	private Role role;
	
	public UserRole() {
		super();
		
	}

	

	public UserRole(long user_roleID, User user, Role role) {
		super();
		this.user_roleID = user_roleID;
		this.user = user;
		this.role = role;
	}



	public long getUser_roleID() {
		return user_roleID;
	}

	public void setUser_roleID(long user_roleID) {
		this.user_roleID = user_roleID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	

}
