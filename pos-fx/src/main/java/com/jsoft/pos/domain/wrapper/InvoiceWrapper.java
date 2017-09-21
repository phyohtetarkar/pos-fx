package com.jsoft.pos.domain.wrapper;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class InvoiceWrapper {

	private IntegerProperty totalPrice = new SimpleIntegerProperty();
	private IntegerProperty totalItem = new SimpleIntegerProperty();
	private IntegerProperty taxAmount = new SimpleIntegerProperty();
	private IntegerProperty discount = new SimpleIntegerProperty();
	private IntegerProperty payPrice = new SimpleIntegerProperty();
	private IntegerProperty change = new SimpleIntegerProperty();

	public InvoiceWrapper() {

	}

	public IntegerProperty totalPriceProperty() {
		return this.totalPrice;
	}

	public IntegerProperty totalItemProperty() {
		return this.totalItem;
	}

	public IntegerProperty taxAmountProperty() {
		return this.taxAmount;
	}

	public IntegerProperty discountProperty() {
		return this.discount;
	}

	public IntegerProperty payPriceProperty() {
		return this.payPrice;
	}

	public IntegerProperty changeProperty() {
		return this.change;
	}

}