package com.jsoft.pos.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jsoft.pos.domain.Supplier;
import com.jsoft.pos.view.model.PagableViewModel;

public class SuppliersView extends PagableView<Supplier> {

	@Override
	protected PagableViewModel<Supplier> model() {
		return null;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);
	}
}
