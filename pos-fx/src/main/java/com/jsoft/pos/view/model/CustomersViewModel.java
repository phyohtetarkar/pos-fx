package com.jsoft.pos.view.model;

import com.jsoft.pos.domain.Customer;
import com.jsoft.pos.service.CustomerService;
import com.jsoft.pos.util.AlertUtil;
import com.jsoft.pos.util.RetrofitSingleton;
import com.jsoft.pos.util.ServerStatus;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CustomersViewModel extends PagableViewModel<Customer> {
	
	private CustomerService service;
	
	private StringProperty name = new SimpleStringProperty();
	
	public CustomersViewModel() {
		service = RetrofitSingleton.getInstance().create(CustomerService.class);
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
		int offset = currentPage.get() * LIMIT;

		if (!loading.get()) {
			loading.set(true);
		}

		service.search(name.get(), offset, LIMIT).enqueue(listCallBack());
	}

	public final StringProperty nameProperty() {
		return name;
	}
}
