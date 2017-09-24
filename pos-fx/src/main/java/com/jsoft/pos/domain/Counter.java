package com.jsoft.pos.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
public class Counter implements Serializable, Nameable {

	private int id;
	private String code;

	private boolean deleted;
	private Security security;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
	@Override
	public String getName() {
		return code;
	}

	@Override
	public void setName(String name) {
		this.code = name;
	}

}