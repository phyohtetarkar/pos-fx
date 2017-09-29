package com.jsoft.pos;

import com.jsoft.pos.domain.Employee;

public class Application {

	private static Application INSTANCE;

	private Employee loginUser;

	private Application() {

	}

	public static Application getContext() {
		if (INSTANCE == null) {
			INSTANCE = new Application();
		}

		return INSTANCE;
	}

	public Employee getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(Employee loginUser) {
		this.loginUser = loginUser;
	}

}
