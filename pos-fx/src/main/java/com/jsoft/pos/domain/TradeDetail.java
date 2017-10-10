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
public class TradeDetail implements Serializable {
	
	/*private long id;
	private int totalPrice;
	private int quantity;
	private int pricePerItem;
	private Trade trade;
	private Item item;

	private boolean deleted;*/

	private LongProperty id = new SimpleLongProperty();
	private StringProperty totalPrice = new SimpleStringProperty();
	private StringProperty quantity = new SimpleStringProperty();
	private StringProperty pricePerItem = new SimpleStringProperty();
	private ObjectProperty<Trade> trade = new SimpleObjectProperty<>();
	private ObjectProperty<Item> item = new SimpleObjectProperty<>();
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

	public StringProperty quantityProperty() {
		return this.quantity;
	}

	public int getQuantity() {
		return Integer.parseInt(this.quantityProperty().get());
	}

	public void setQuantity(final int quantity) {
		this.quantityProperty().set(String.valueOf(quantity));
	}

	public StringProperty pricePerItemProperty() {
		return this.pricePerItem;
	}

	public int getPricePerItem() {
		return Integer.parseInt(this.pricePerItemProperty().get());
	}

	public void setPricePerItem(final int pricePerItem) {
		this.pricePerItemProperty().set(String.valueOf(pricePerItem));
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

	public ObjectProperty<Item> itemProperty() {
		return this.item;
	}

	public Item getItem() {
		return this.itemProperty().get();
	}

	public void setItem(final Item item) {
		this.itemProperty().set(item);
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