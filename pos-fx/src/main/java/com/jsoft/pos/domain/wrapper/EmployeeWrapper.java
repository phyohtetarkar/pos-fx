package com.jsoft.pos.domain.wrapper;

import com.jsoft.pos.domain.Employee.Role;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EmployeeWrapper extends PersonWrapper {

	private StringProperty loginId = new SimpleStringProperty();
	private StringProperty password = new SimpleStringProperty();
	private ObjectProperty<Role> role = new SimpleObjectProperty<>();

	public EmployeeWrapper() {

	}

	public StringProperty loginIdProperty() {
		return this.loginId;
	}

	public StringProperty passwordProperty() {
		return this.password;
	}

	public ObjectProperty<Role> roleProperty() {
		return this.role;
	}

}