package com.jsoft.pos.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Employee extends Person implements Serializable {

	public enum Role {
		ADMIN, LEADER, STAFF
	}

	private String loginId;
	private String password;
	private Role role;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}