package com.jsoft.pos.domain.wrapper;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SupplierWrapper extends PersonWrapper {

	private StringProperty company = new SimpleStringProperty();
	
	public SupplierWrapper() {
		
	}

	public StringProperty companyProperty() {
		return this.company;
	}

}