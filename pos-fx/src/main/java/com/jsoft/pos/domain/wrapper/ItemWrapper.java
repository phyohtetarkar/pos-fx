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

	private IntegerProperty id = new SimpleIntegerProperty();
	private StringProperty code = new SimpleStringProperty();
	private StringProperty name = new SimpleStringProperty();
	private StringProperty purchasePrice = new SimpleStringProperty();
	private StringProperty retailPrice = new SimpleStringProperty();
	private StringProperty quantity = new SimpleStringProperty();
	private StringProperty photo = new SimpleStringProperty();
	private StringProperty remark = new SimpleStringProperty();
	private ObjectProperty<Category> category = new SimpleObjectProperty<>();
	
	public ItemWrapper() {
	}
	
	public Item build() {
		Item item = new Item();
		item.setId(id.get());
		item.setCode(code.get());
		item.setName(name.get());
		item.setPurchasePrice(Integer.parseInt(purchasePrice.get()));
		item.setRetailPrice(Integer.parseInt(retailPrice.get()));
		item.setQuantity(Integer.parseInt(quantity.get()));
		item.setPhoto(photo.get());
		item.setCategory(category.get());
		item.setRemark(remark.get());
		
		return item;
	}
	
	public void setItem(Item item) {
		id.set(item.getId());
		code.set(item.getCode());
		name.set(item.getName());
		purchasePrice.set(String.valueOf(item.getPurchasePrice()));
		retailPrice.set(String.valueOf(item.getRetailPrice()));
		quantity.set(String.valueOf(item.getQuantity()));
		photo.set(item.getPhoto());
		category.set(item.getCategory());
		remark.set(item.getRemark());
	}

	public final StringProperty codeProperty() {
		return code;
	}

	public final StringProperty nameProperty() {
		return name;
	}

	public final StringProperty purchasePriceProperty() {
		return purchasePrice;
	}

	public final StringProperty retailPriceProperty() {
		return retailPrice;
	}

	public final StringProperty photoProperty() {
		return photo;
	}

	public final StringProperty quantityProperty() {
		return quantity;
	}

	public final StringProperty remarkProperty() {
		return remark;
	}

	public final ObjectProperty<Category> categoryProperty() {
		return category;
	}
}