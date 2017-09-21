package com.jsoft.pos.domain.wrapper;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class PersonWrapper {

	private StringProperty name = new SimpleStringProperty();
	private StringProperty photo = new SimpleStringProperty();
	private StringProperty remark = new SimpleStringProperty();
	private ContactWrapper contact;

	private SecurityWrapper security;

	public PersonWrapper() {
		contact = new ContactWrapper();
		security = new SecurityWrapper();
	}

	public StringProperty nameProperty() {
		return this.name;
	}

	public StringProperty photoProperty() {
		return this.photo;
	}

	public StringProperty remarkProperty() {
		return this.remark;
	}

	public ContactWrapper getContact() {
		return contact;
	}

	public SecurityWrapper getSecurity() {
		return security;
	}
}