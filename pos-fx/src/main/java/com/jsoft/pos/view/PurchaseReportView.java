package com.jsoft.pos.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jsoft.pos.domain.Purchase;
import com.jsoft.pos.view.model.PagableViewModel;

public class PurchaseReportView extends PagableView<Purchase> {

	@Override
	protected PagableViewModel<Purchase> model() {
		return null;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);
	}
}
