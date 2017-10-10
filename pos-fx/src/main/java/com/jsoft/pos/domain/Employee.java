package com.jsoft.pos.domain;

import java.io.Serializable;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@SuppressWarnings("serial")
public class Employee extends Person implements Serializable {

	public enum Role {
		ADMIN, LEADER, STAFF
	}
	
	/*private String loginId;
	private String password;
	private Role role;*/

	private StringProperty loginId = new SimpleStringProperty();
	private StringProperty password = new SimpleStringProperty();
	private ObjectProperty<Role> role = new SimpleObjectProperty<>();

	public StringProperty loginIdProperty() {
		return this.loginId;
	}

	public String getLoginId() {
		return this.loginIdProperty().get();
	}

	public void setLoginId(final String loginId) {
		this.loginIdProperty().set(loginId);
	}

	public StringProperty passwordProperty() {
		return this.password;
	}

	public String getPassword() {
		return this.passwordProperty().get();
	}

	public void setPassword(final String password) {
		this.passwordProperty().set(password);
	}

	public ObjectProperty<Role> roleProperty() {
		return this.role;
	}

	public Role getRole() {
		return this.roleProperty().get();
	}

	public void setRole(final Role role) {
		this.roleProperty().set(role);
	}

}