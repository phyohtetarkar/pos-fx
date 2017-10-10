package com.jsoft.pos.domain;

import java.io.Serializable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

@SuppressWarnings("serial")
public class Sale extends Trade implements Serializable {
	
	/*private int profit;
	private Customer customer;
	private Counter counter;*/

	private IntegerProperty profit = new SimpleIntegerProperty();
	private ObjectProperty<Customer> customer = new SimpleObjectProperty<>();
	private ObjectProperty<Counter> counter = new SimpleObjectProperty<>();

	public IntegerProperty profitProperty() {
		return this.profit;
	}

	public int getProfit() {
		return this.profitProperty().get();
	}

	public void setProfit(final int profit) {
		this.profitProperty().set(profit);
	}

	public ObjectProperty<Customer> customerProperty() {
		return this.customer;
	}

	public Customer getCustomer() {
		return this.customerProperty().get();
	}

	public void setCustomer(final Customer customer) {
		this.customerProperty().set(customer);
	}

	public ObjectProperty<Counter> counterProperty() {
		return this.counter;
	}

	public Counter getCounter() {
		return this.counterProperty().get();
	}

	public void setCounter(final Counter counter) {
		this.counterProperty().set(counter);
	}

}