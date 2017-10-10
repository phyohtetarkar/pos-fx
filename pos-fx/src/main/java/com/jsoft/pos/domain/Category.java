package com.jsoft.pos.domain;

import java.io.Serializable;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@SuppressWarnings("serial")
public class Category implements Serializable, Nameable {

	/*private int id;
	private String name;

	private boolean deleted;*/
	
	private IntegerProperty id = new SimpleIntegerProperty();
	private StringProperty name = new SimpleStringProperty();
	private BooleanProperty deleted = new SimpleBooleanProperty();
	
	private Security security;

	public Category() {
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
	

	public StringProperty nameProperty() {
		return this.name;
	}
	

	public String getName() {
		return this.nameProperty().get();
	}
	

	public void setName(final String name) {
		this.nameProperty().set(name);
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

	@Override
	public String toString() {
		return name.get();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id.get();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id.get() != other.getId())
			return false;
		return true;
	}

}