package com.jsoft.pos.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Supplier extends Person implements Serializable {

	private String company;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}