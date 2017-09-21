package com.jsoft.pos.domain.wrapper;

import com.jsoft.pos.domain.Category;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ItemWrapper {

	private StringProperty code = new SimpleStringProperty();
	private StringProperty name = new SimpleStringProperty();
	private IntegerProperty purchasePrice = new SimpleIntegerProperty();
	private IntegerProperty retailPrice = new SimpleIntegerProperty();
	private StringProperty photo = new SimpleStringProperty();
	private IntegerProperty quantity = new SimpleIntegerProperty();
	private StringProperty remark = new SimpleStringProperty();
	private ObjectProperty<Category> category = new SimpleObjectProperty<>();

	private SecurityWrapper security;

	public ItemWrapper() {
		security = new SecurityWrapper();
	}

	public StringProperty codeProperty() {
		return this.code;
	}

	public StringProperty nameProperty() {
		return this.name;
	}

	public IntegerProperty purchasePriceProperty() {
		return this.purchasePrice;
	}

	public IntegerProperty retailPriceProperty() {
		return this.retailPrice;
	}

	public StringProperty photoProperty() {
		return this.photo;
	}

	public IntegerProperty quantityProperty() {
		return this.quantity;
	}

	public StringProperty remarkProperty() {
		return this.remark;
	}

	public ObjectProperty<Category> categoryProperty() {
		return this.category;
	}

	public SecurityWrapper getSecurity() {
		return security;
	}
}