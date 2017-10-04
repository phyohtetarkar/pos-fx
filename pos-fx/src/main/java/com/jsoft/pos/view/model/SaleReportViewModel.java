package com.jsoft.pos.view.model;

import com.jsoft.pos.domain.Employee;
import com.jsoft.pos.domain.Sale;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SaleReportViewModel extends PagableViewModel<Sale> {


	private StringProperty dateFrom = new SimpleStringProperty();
	private StringProperty dateTo = new SimpleStringProperty();
	private ObjectProperty<Employee> employee = new SimpleObjectProperty<>();

	public SaleReportViewModel() {
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
