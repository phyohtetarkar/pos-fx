package com.jsoft.pos.domain.wrapper;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ContactWrapper {

	private StringProperty phone = new SimpleStringProperty();
	private StringProperty email = new SimpleStringProperty();
	private StringProperty address = new SimpleStringProperty();

	public StringProperty phoneProperty() {
		return this.phone;
	}

	public StringProperty emailProperty() {
		return this.email;
	}

	public StringProperty addressProperty() {
		return this.address;
	}

}