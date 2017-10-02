package com.jsoft.pos.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
public class Counter implements Serializable, Nameable {

	private int id;
	private String code;

	private boolean deleted;
	private Security security;

	public Counter() {
		security = new Security();
	}

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

	@Override
	public String toString() {
		return code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		if (id != other.id)
			return false;
		return true;
	}

}