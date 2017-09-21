package com.jsoft.pos.domain.wrapper;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CategoryWrapper {

	private StringProperty name = new SimpleStringProperty();

	private SecurityWrapper security;

	public CategoryWrapper() {
		security = new SecurityWrapper();
	}
	
	public StringProperty nameProperty() {
		return this.name;
	}

	public SecurityWrapper getSecurity() {
		return security;
	}
}