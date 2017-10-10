package com.jsoft.pos.domain;

import java.io.Serializable;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

@SuppressWarnings("serial")
public class Purchase extends Trade implements Serializable {

	// private Supplier supplier;

	private ObjectProperty<Supplier> supplier = new SimpleObjectProperty<>();

	public ObjectProperty<Supplier> supplierProperty() {
		return this.supplier;
	}

	public Supplier getSupplier() {
		return this.supplierProperty().get();
	}

	public void setSupplier(final Supplier supplier) {
		this.supplierProperty().set(supplier);
	}

}