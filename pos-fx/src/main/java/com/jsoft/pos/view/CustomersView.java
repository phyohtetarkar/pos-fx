package com.jsoft.pos.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jsoft.pos.domain.Customer;
import com.jsoft.pos.view.model.PagableViewModel;

public class CustomersView extends PagableView<Customer> {

	@Override
	protected PagableViewModel<Customer> model() {
		return null;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);
	}
}
