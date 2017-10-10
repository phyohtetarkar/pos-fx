package com.jsoft.pos.domain;

import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@SuppressWarnings("serial")
public class Contact implements Serializable {

	/*private String phone;
	private String email;
	private String address;*/

	private StringProperty phone = new SimpleStringProperty();
	private StringProperty email = new SimpleStringProperty();
	private StringProperty address = new SimpleStringProperty();
	
	public StringProperty phoneProperty() {
		return this.phone;
	}
	
	public String getPhone() {
		return this.phoneProperty().get();
	}
	
	public void setPhone(final String phone) {
		this.phoneProperty().set(phone);
	}
	
	public StringProperty emailProperty() {
		return this.email;
	}
	
	public String getEmail() {
		return this.emailProperty().get();
	}
	
	public void setEmail(final String email) {
		this.emailProperty().set(email);
	}
	
	public StringProperty addressProperty() {
		return this.address;
	}
	
	public String getAddress() {
		return this.addressProperty().get();
	}
	
	public void setAddress(final String address) {
		this.addressProperty().set(address);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address.get() == null) ? 0 : address.get().hashCode());
		result = prime * result + ((email.get() == null) ? 0 : email.get().hashCode());
		result = prime * result + ((phone.get() == null) ? 0 : phone.get().hashCode());
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
		Contact other = (Contact) obj;
		if (address.get() == null) {
			if (other.address.get() != null)
				return false;
		} else if (!address.get().equals(other.address.get()))
			return false;
		if (email.get() == null) {
			if (other.email.get() != null)
				return false;
		} else if (!email.get().equals(other.email.get()))
			return false;
		if (phone.get() == null) {
			if (other.phone.get() != null)
				return false;
		} else if (!phone.get().equals(other.phone.get()))
			return false;
		return true;
	}
	
}