package com.jsoft.pos.domain.wrapper;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CounterWrapper {

	private StringProperty code = new SimpleStringProperty();

	private SecurityWrapper security;

	public CounterWrapper() {
		security = new SecurityWrapper();
	}

	public StringProperty codeProperty() {
		return this.code;
	}

	public SecurityWrapper getSecurity() {
		return security;
	}
}