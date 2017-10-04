package com.jsoft.pos.domain.wrapper;

import com.jsoft.pos.domain.Category;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CategoryWrapper {

	public StringProperty name = new SimpleStringProperty();
	
	public void set(Category category) {
		
	}
	
	public final StringProperty nameProperty() {
		return name;
	}
	
}
