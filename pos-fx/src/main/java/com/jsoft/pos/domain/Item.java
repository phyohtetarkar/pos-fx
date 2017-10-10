package com.jsoft.pos.domain;

import java.io.Serializable;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@SuppressWarnings("serial")
public class Item implements Serializable {
	
	/*private int id;
	private String code;
	private String name;
	private int purchasePrice;
	private int retailPrice;
	private String photo;
	private int quantity;
	private String remark;
	private Category category;

	private boolean deleted;*/

	private IntegerProperty id = new SimpleIntegerProperty();
	private StringProperty code = new SimpleStringProperty();
	private StringProperty name = new SimpleStringProperty();
	private StringProperty purchasePrice = new SimpleStringProperty();
	private StringProperty retailPrice = new SimpleStringProperty();
	private StringProperty quantity = new SimpleStringProperty();
	private StringProperty photo = new SimpleStringProperty();
	private StringProperty remark = new SimpleStringProperty();
	private ObjectProperty<Category> category = new SimpleObjectProperty<>();
	private BooleanProperty deleted = new SimpleBooleanProperty();

	private Security security;

	public Item() {
		security = new Security();
	}

	public IntegerProperty idProperty() {
		return this.id;
	}

	public int getId() {
		return this.idProperty().get();
	}

	public void setId(final int id) {
		this.idProperty().set(id);
	}

	public StringProperty codeProperty() {
		return this.code;
	}

	public String getCode() {
		return this.codeProperty().get();
	}

	public void setCode(final String code) {
		this.codeProperty().set(code);
	}

	public StringProperty nameProperty() {
		return this.name;
	}

	public String getName() {
		return this.nameProperty().get();
	}

	public void setName(final String name) {
		this.nameProperty().set(name);
	}

	public StringProperty purchasePriceProperty() {
		return this.purchasePrice;
	}

	public int getPurchasePrice() {
		return Integer.parseInt(this.purchasePriceProperty().get());
	}

	public void setPurchasePrice(final int purchasePrice) {
		this.purchasePriceProperty().set(String.valueOf(purchasePrice));
	}

	public StringProperty retailPriceProperty() {
		return this.retailPrice;
	}

	public int getRetailPrice() {
		return Integer.parseInt(this.retailPriceProperty().get());
	}

	public void setRetailPrice(final int retailPrice) {
		this.retailPriceProperty().set(String.valueOf(retailPrice));
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

	public StringProperty photoProperty() {
		return this.photo;
	}

	public String getPhoto() {
		return this.photoProperty().get();
	}

	public void setPhoto(final String photo) {
		this.photoProperty().set(photo);
	}

	public StringProperty remarkProperty() {
		return this.remark;
	}

	public String getRemark() {
		return this.remarkProperty().get();
	}

	public void setRemark(final String remark) {
		this.remarkProperty().set(remark);
	}

	public ObjectProperty<Category> categoryProperty() {
		return this.category;
	}

	public Category getCategory() {
		return this.categoryProperty().get();
	}

	public void setCategory(final Category category) {
		this.categoryProperty().set(category);
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

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

}