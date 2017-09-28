package com.jsoft.pos.view.model;

import com.jsoft.pos.domain.Employee;
import com.jsoft.pos.service.EmployeeService;
import com.jsoft.pos.util.AlertUtil;
import com.jsoft.pos.util.RetrofitSingleton;
import com.jsoft.pos.util.ServerStatus;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EmployeesViewModel extends PagableViewModel<Employee> {

	private EmployeeService service;

	private StringProperty name = new SimpleStringProperty();

	public EmployeesViewModel() {
		service = RetrofitSingleton.getInstance().create(EmployeeService.class);
	}

	@Override
	public void init() {
		if (ServerStatus.isReachable()) {
			search();
		} else {
			AlertUtil.queueToast(ServerStatus.CONNECTION_ERROR);
		}
	}

	@Override
	public void search() {
		if (ServerStatus.isReachable()) {
			loading.set(true);
			service.count(name.get()).enqueue(countCallBack());

		} else {
			AlertUtil.queueToast(ServerStatus.CONNECTION_ERROR);
		}
	}

	@Override
	public void queryList() {
		int offset = currentPage.get() * limit;

		if (!loading.get()) {
			loading.set(true);
		}

		service.search(name.get(), offset, limit).enqueue(listCallBack());
	}

	public final StringProperty nameProperty() {
		return name;
	}

}
