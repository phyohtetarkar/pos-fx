package com.jsoft.pos.view.model;

import com.jsoft.pos.domain.Employee;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EmployeesViewModel extends PagableViewModel<Employee> {


	private StringProperty name = new SimpleStringProperty();

	public EmployeesViewModel() {
	}

	@Override
	public void init() {

	}

	@Override
	public void search() {

	}

	@Override
	public void searchPage() {

	}

	public final StringProperty nameProperty() {
		return name;
	}

}
