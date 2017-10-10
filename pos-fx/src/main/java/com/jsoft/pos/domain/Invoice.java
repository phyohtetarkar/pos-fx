package com.jsoft.pos.domain;

import java.io.Serializable;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@SuppressWarnings("serial")
public class Invoice implements Serializable {

	/*
	 * private long id; private int totalPrice; private int totalItem; private
	 * int taxAmount; private int discount; private int payPrice; private int
	 * change; private Trade trade;
	 * 
	 * private boolean deleted;
	 */

	private LongProperty id = new SimpleLongProperty();
	private StringProperty totalPrice = new SimpleStringProperty();
	private StringProperty totalItem = new SimpleStringProperty();
	private StringProperty taxAmount = new SimpleStringProperty();
	private StringProperty discount = new SimpleStringProperty();
	private StringProperty payPrice = new SimpleStringProperty();
	private StringProperty change = new SimpleStringProperty();
	private ObjectProperty<Trade> trade = new SimpleObjectProperty<>();
	private BooleanProperty deleted = new SimpleBooleanProperty();

	public LongProperty idProperty() {
		return this.id;
	}

	public long getId() {
		return this.idProperty().get();
	}

	public void setId(final long id) {
		this.idProperty().set(id);
	}

	public StringProperty totalPriceProperty() {
		return this.totalPrice;
	}

	public int getTotalPrice() {
		return Integer.parseInt(this.totalPriceProperty().get());
	}

	public void setTotalPrice(final int totalPrice) {
		this.totalPriceProperty().set(String.valueOf(totalPrice));
	}

	public StringProperty totalItemProperty() {
		return this.totalItem;
	}

	public int getTotalItem() {
		return Integer.parseInt(this.totalItemProperty().get());
	}

	public void setTotalItem(final int totalItem) {
		this.totalItemProperty().set(String.valueOf(totalItem));
	}

	public StringProperty taxAmountProperty() {
		return this.taxAmount;
	}

	public int getTaxAmount() {
		return Integer.parseInt(this.taxAmountProperty().get());
	}

	public void setTaxAmount(final int taxAmount) {
		this.taxAmountProperty().set(String.valueOf(taxAmount));
	}

	public StringProperty discountProperty() {
		return this.discount;
	}

	public int getDiscount() {
		return Integer.parseInt(this.discountProperty().get());
	}

	public void setDiscount(final int discount) {
		this.discountProperty().set(String.valueOf(discount));
	}

	public StringProperty payPriceProperty() {
		return this.payPrice;
	}

	public int getPayPrice() {
		return Integer.parseInt(this.payPriceProperty().get());
	}

	public void setPayPrice(final int payPrice) {
		this.payPriceProperty().set(String.valueOf(payPrice));
	}

	public StringProperty changeProperty() {
		return this.change;
	}

	public int getChange() {
		return Integer.parseInt(this.changeProperty().get());
	}

	public void setChange(final int change) {
		this.changeProperty().set(String.valueOf(change));
	}

	public ObjectProperty<Trade> tradeProperty() {
		return this.trade;
	}

	public Trade getTrade() {
		return this.tradeProperty().get();
	}

	public void setTrade(final Trade trade) {
		this.tradeProperty().set(trade);
	}

	public BooleanProperty deletedProperty() {
		return this.deleted;
	}

	public boolean isDeleted() {
		return this.deletedProperty().get();
	}

	public void setDeleted(final boolean deleted) {
		this.deletedProperty().set(deleted);
	}

}