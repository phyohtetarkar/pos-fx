package com.jsoft.pos.view.model;

import com.jsoft.pos.domain.Supplier;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SuppliersViewModel extends PagableViewModel<Supplier> {


	private StringProperty name = new SimpleStringProperty();

	public SuppliersViewModel() {
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
