package com.jsoft.pos.domain.wrapper;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class TradeDetailWrapper {

	private IntegerProperty totalPrice = new SimpleIntegerProperty();
	private IntegerProperty quantity = new SimpleIntegerProperty();
	private IntegerProperty pricePerItem = new SimpleIntegerProperty();
	private TradeWrapper trade;
	private ItemWrapper item;

}