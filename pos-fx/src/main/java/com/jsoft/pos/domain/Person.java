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
public abstract class Person implements Serializable {
	
	/*private int id;
	private String name;
	private String photo;
	private String remark;
	private Contact contact;

	private boolean deleted;*/

	private IntegerProperty id = new SimpleIntegerProperty();
	private StringProperty name = new SimpleStringProperty();
	private StringProperty photo = new SimpleStringProperty();
	private StringProperty remark = new SimpleStringProperty();
	private ObjectProperty<Contact> contact = new SimpleObjectProperty<>();
	private BooleanProperty deleted = new SimpleBooleanProperty();

	private Security security;
	
	public Person() {
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

	public ObjectProperty<Contact> contactProperty() {
		return this.contact;
	}

	public Contact getContact() {
		return this.contactProperty().get();
	}

	public void setContact(final Contact contact) {
		this.contactProperty().set(contact);
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

}