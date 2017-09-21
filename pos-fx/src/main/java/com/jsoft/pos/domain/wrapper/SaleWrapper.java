package com.jsoft.pos.domain.wrapper;

import com.jsoft.pos.domain.Counter;
import com.jsoft.pos.domain.Customer;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class SaleWrapper extends TradeWrapper {

	private IntegerProperty profit = new SimpleIntegerProperty();
	private ObjectProperty<Customer> customer = new SimpleObjectProperty<>();
	private ObjectProperty<Counter> counter = new SimpleObjectProperty<>();

	public IntegerProperty profitProperty() {
		return this.profit;
	}

	public ObjectProperty<Customer> customerProperty() {
		return this.customer;
	}

	public ObjectProperty<Counter> counterProperty() {
		return this.counter;
	}

}