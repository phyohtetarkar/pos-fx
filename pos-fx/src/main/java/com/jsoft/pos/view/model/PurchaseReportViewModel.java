package com.jsoft.pos.view.model;

import com.jsoft.pos.domain.Employee;
import com.jsoft.pos.domain.Purchase;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PurchaseReportViewModel extends PagableViewModel<Purchase> {


	private StringProperty dateFrom = new SimpleStringProperty();
	private StringProperty dateTo = new SimpleStringProperty();
	private ObjectProperty<Employee> employee = new SimpleObjectProperty<>();

	public PurchaseReportViewModel() {
	}

	@Override
	public void init() {

	}

	@Override
	public void search() {

	}

	@Override
	public void searchPage() {

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
