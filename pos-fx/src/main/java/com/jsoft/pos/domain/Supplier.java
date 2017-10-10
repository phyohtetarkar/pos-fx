package com.jsoft.pos.domain;

import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@SuppressWarnings("serial")
public class Supplier extends Person implements Serializable {

	// private String company;

	private StringProperty company = new SimpleStringProperty();

	public StringProperty companyProperty() {
		return this.company;
	}

	public String getCompany() {
		return this.companyProperty().get();
	}

	public void setCompany(final String company) {
		this.companyProperty().set(company);
	}

}