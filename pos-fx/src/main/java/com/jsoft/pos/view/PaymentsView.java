package com.jsoft.pos.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jsoft.pos.domain.Payment;
import com.jsoft.pos.view.model.SinglePageViewModel;

public class PaymentsView extends SinglePageView<Payment> {

	@Override
	protected SinglePageViewModel<Payment> model() {
		return null;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);
	}
}
