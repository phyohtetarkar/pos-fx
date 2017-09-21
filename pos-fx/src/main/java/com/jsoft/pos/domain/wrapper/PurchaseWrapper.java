package com.jsoft.pos.domain.wrapper;

public class PurchaseWrapper extends TradeWrapper {

	private SupplierWrapper supplier;
	
	public PurchaseWrapper() {
		
	}

	public SupplierWrapper getSupplier() {
		return supplier;
	}
}