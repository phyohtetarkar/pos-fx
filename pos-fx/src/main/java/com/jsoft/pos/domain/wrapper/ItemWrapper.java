package com.jsoft.pos.domain.wrapper;

import com.jsoft.pos.domain.Category;
import com.jsoft.pos.domain.Item;

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
	
	public Item build() {
		Item item = new Item();
		item.setCode(code.get());
		item.setName(name.get());
		item.setPurchasePrice(purchasePrice.get());
		item.setRetailPrice(retailPrice.get());
		item.setPhoto(photo.get());
		item.setCategory(category.get());
		item.setRemark(remark.get());
		
		return item;
	}

	public final StringProperty codeProperty() {
		return code;
	}

	public final StringProperty nameProperty() {
		return name;
	}

	public final IntegerProperty purchasePriceProperty() {
		return purchasePrice;
	}

	public final IntegerProperty retailPriceProperty() {
		return retailPrice;
	}

	public final StringProperty photoProperty() {
		return photo;
	}

	public final IntegerProperty quantityProperty() {
		return quantity;
	}

	public final StringProperty remarkProperty() {
		return remark;
	}

	public final ObjectProperty<Category> categoryProperty() {
		return category;
	}

	public SecurityWrapper getSecurity() {
		return security;
	}
}