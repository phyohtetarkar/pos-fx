package com.jsoft.pos.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Purchase extends Trade implements Serializable {

	private Supplier supplier;

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

}