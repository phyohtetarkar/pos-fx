package com.jsoft.pos.domain.wrapper;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PaymentWrapper {

	private StringProperty type = new SimpleStringProperty();
	private StringProperty remark = new SimpleStringProperty();

	private SecurityWrapper security;

	public PaymentWrapper() {
		security = new SecurityWrapper();
	}

	public StringProperty typeProperty() {
		return this.type;
	}

	public StringProperty remarkProperty() {
		return this.remark;
	}

	public SecurityWrapper getSecurity() {
		return security;
	}
}