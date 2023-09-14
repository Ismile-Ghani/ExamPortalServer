package com.exam.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Role {
	
	@Id
	private long roleId;
	private String roleName;
	
	@jakarta.persistence.OneToMany(cascade = jakarta.persistence.CascadeType.ALL,fetch = jakarta.persistence.FetchType.LAZY,mappedBy = "role")
	Set<UserRole> userRole = new HashSet<UserRole>();
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	



	public Role(long roleId, String roleName, Set<UserRole> userRole) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.userRole = userRole;
	}







	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}







	public Set<UserRole> getUserRole() {
		return userRole;
	}







	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}



	
	
	
	
	
	
	

}
