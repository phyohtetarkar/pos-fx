package com.jsoft.pos.view.model;

import com.jsoft.pos.domain.Supplier;
import com.jsoft.pos.service.SupplierService;
import com.jsoft.pos.util.AlertUtil;
import com.jsoft.pos.util.RetrofitSingleton;
import com.jsoft.pos.util.ServerStatus;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SuppliersViewModel extends PagableViewModel<Supplier> {

	private SupplierService service;

	private StringProperty name = new SimpleStringProperty();

	public SuppliersViewModel() {
		service = RetrofitSingleton.getInstance().create(SupplierService.class);
	}

	@Override
	public void init() {
		if (ServerStatus.isReachable()) {
			search();
		} else {
			AlertUtil.queueToast(ServerStatus.CONNECTION_ERROR);
		}
	}

	@Override
	public void search() {
		if (ServerStatus.isReachable()) {
			loading.set(true);
			service.count(name.get()).enqueue(countCallBack());

		} else {
			AlertUtil.queueToast(ServerStatus.CONNECTION_ERROR);
		}
	}

	@Override
	public void queryList() {
		int offset = currentPage.get() * LIMIT;

		if (!loading.get()) {
			loading.set(true);
		}

		service.search(name.get(), offset, LIMIT).enqueue(listCallBack());
	}

	public final StringProperty nameProperty() {
		return name;
	}

}
