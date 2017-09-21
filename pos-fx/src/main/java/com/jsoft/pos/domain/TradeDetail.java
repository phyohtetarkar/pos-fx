package com.jsoft.pos.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TradeDetail implements Serializable {

	private long id;
	private int totalPrice;
	private int quantity;
	private int pricePerItem;
	private Trade trade;
	private Item item;

	private boolean deleted;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPricePerItem() {
		return pricePerItem;
	}

	public void setPricePerItem(int pricePerItem) {
		this.pricePerItem = pricePerItem;
	}

	public Trade getTrade() {
		return trade;
	}

	public void setTrade(Trade trade) {
		this.trade = trade;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}