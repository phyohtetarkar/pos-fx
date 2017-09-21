package com.jsoft.pos.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Sale extends Trade implements Serializable {

	private int profit;
	private Customer customer;
	private Counter counter;

	public int getProfit() {
		return profit;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Counter getCounter() {
		return counter;
	}

	public void setCounter(Counter counter) {
		this.counter = counter;
	}

}