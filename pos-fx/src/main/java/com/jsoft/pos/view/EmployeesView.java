package com.jsoft.pos.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jsoft.pos.domain.Employee;
import com.jsoft.pos.view.model.PagableViewModel;

public class EmployeesView extends PagableView<Employee> {

	@Override
	protected PagableViewModel<Employee> model() {
		return null;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		super.initialize(location, resources);
	}
}
