package com.jsoft.pos.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jsoft.pos.domain.Sale;
import com.jsoft.pos.view.model.PagableViewModel;

public class SaleReportView extends PagableView<Sale> {

	@Override
	protected PagableViewModel<Sale> model() {
		return null;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);
	}
}
