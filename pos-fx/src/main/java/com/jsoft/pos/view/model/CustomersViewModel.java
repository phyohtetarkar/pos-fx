package com.jsoft.pos.view.model;

import com.jsoft.pos.domain.Customer;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CustomersViewModel extends PagableViewModel<Customer> {
	
	private StringProperty name = new SimpleStringProperty();
	
	public CustomersViewModel() {
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
