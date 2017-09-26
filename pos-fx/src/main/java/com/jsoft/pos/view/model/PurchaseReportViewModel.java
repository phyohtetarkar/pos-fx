package com.jsoft.pos.view.model;

import com.jsoft.pos.domain.Employee;
import com.jsoft.pos.domain.Purchase;
import com.jsoft.pos.service.PurchaseService;
import com.jsoft.pos.util.AlertUtil;
import com.jsoft.pos.util.RetrofitSingleton;
import com.jsoft.pos.util.ServerStatus;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PurchaseReportViewModel extends PagableViewModel<Purchase> {
	
	private PurchaseService service;
	
	private StringProperty dateFrom = new SimpleStringProperty();
	private StringProperty dateTo = new SimpleStringProperty();
	private ObjectProperty<Employee> employee = new SimpleObjectProperty<>();
	
	public PurchaseReportViewModel() {
		service = RetrofitSingleton.getInstance().create(PurchaseService.class);
	}

	public void init() {
		if (ServerStatus.isReachable()) {
			search();
		} else {
			AlertUtil.queueToast(ServerStatus.CONNECTION_ERROR);
		}
	}

	public void search() {
		if (ServerStatus.isReachable()) {
			loading.set(true);
			service.count(dateFrom.get(), dateTo.get(), employee.get() == null ? 0 : employee.get().getId())
					.enqueue(countCallBack());

		} else {
			AlertUtil.queueToast(ServerStatus.CONNECTION_ERROR);
		}
	}

	@Override
	public void loadValues() {
		int offset = currentPage.get() * LIMIT;

		if (!loading.get()) {
			loading.set(true);
		}

		service.search(dateFrom.get(), dateTo.get(), employee.get() == null ? 0 : employee.get().getId(), offset, LIMIT)
				.enqueue(valuesCallBack());
	}

	public final StringProperty dateFromProperty() {
		return this.dateFrom;
	}

	public final StringProperty dateToProperty() {
		return this.dateTo;
	}

	public final ObjectProperty<Employee> employeeProperty() {
		return this.employee;
	}

}
