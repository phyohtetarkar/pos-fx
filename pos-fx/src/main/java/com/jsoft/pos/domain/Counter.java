package com.jsoft.pos.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@SuppressWarnings("serial")
public class Counter implements Serializable, Nameable {

	/*
	  private int id; private String code;	  
	  private boolean deleted;
	 */
	
	private IntegerProperty id = new SimpleIntegerProperty();
	private StringProperty code = new SimpleStringProperty();
	private BooleanProperty deleted = new SimpleBooleanProperty();

	private Security security;

	public Counter() {
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

	@JsonIgnore
	@Override
	public String getName() {
		return code.get();
	}

	@Override
	public void setName(String name) {
		setCode(name);
	}

	@Override
	public String toString() {
		return code.get();
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
		Counter other = (Counter) obj;
		if (id.get() != other.getId())
			return false;
		return true;
	}

}