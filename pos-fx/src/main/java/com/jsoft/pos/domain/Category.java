package com.jsoft.pos.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jsoft.pos.util.Utils;

@SuppressWarnings("serial")
public class Category implements Serializable, Nameable {

	private int id;
	private String name;

	private boolean deleted;
	private Security security;
	
	public Category() {
		security = new Security();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

	@JsonIgnore
	public String getCreateDate() {
		return security.getCreation().format(Utils.dateTimeFormatter);
	}
	
	@JsonIgnore
	public String getUpdateDate() {
		return security.getModification().format(Utils.dateTimeFormatter);
	}
	
	@Override
	public String toString() {
		return name;
	}
}