package com.jsoft.pos.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

@SuppressWarnings("serial")
public abstract class Trade implements Serializable {

	public enum Payment {
		CASH, CREDIT
	}
	
	/*private long id;
	@JsonSerialize(using = DateSerializer.class)
	@JsonDeserialize(using = DateDeSerializer.class)
	private LocalDate eventDate;
	private String remark;
	private List<TradeDetail> tradeDetail;
	private Employee employee;
	private Payment payment;

	private boolean deleted;*/

	private LongProperty id = new SimpleLongProperty();
	private ObjectProperty<LocalDate> eventDate = new SimpleObjectProperty<>();
	private StringProperty remark = new SimpleStringProperty();
	private ListProperty<TradeDetail> tradeDetail = new SimpleListProperty<>();
	private ObjectProperty<Employee> employee = new SimpleObjectProperty<>();
	private ObjectProperty<Payment> payment = new SimpleObjectProperty<>();
	private BooleanProperty deleted = new SimpleBooleanProperty();

	private Security security;
	
	public Trade() {
		security = new Security();
	}

	public LongProperty idProperty() {
		return this.id;
	}

	public long getId() {
		return this.idProperty().get();
	}

	public void setId(final long id) {
		this.idProperty().set(id);
	}

	public ObjectProperty<LocalDate> eventDateProperty() {
		return this.eventDate;
	}

	public LocalDate getEventDate() {
		return this.eventDateProperty().get();
	}

	public void setEventDate(final LocalDate eventDate) {
		this.eventDateProperty().set(eventDate);
	}

	public StringProperty remarkProperty() {
		return this.remark;
	}

	public String getRemark() {
		return this.remarkProperty().get();
	}

	public void setRemark(final String remark) {
		this.remarkProperty().set(remark);
	}

	public ListProperty<TradeDetail> tradeDetailProperty() {
		return this.tradeDetail;
	}

	public ObservableList<TradeDetail> getTradeDetail() {
		return this.tradeDetailProperty().get();
	}

	public void setTradeDetail(final ObservableList<TradeDetail> tradeDetail) {
		this.tradeDetailProperty().set(tradeDetail);
	}

	public ObjectProperty<Employee> employeeProperty() {
		return this.employee;
	}

	public Employee getEmployee() {
		return this.employeeProperty().get();
	}

	public void setEmployee(final Employee employee) {
		this.employeeProperty().set(employee);
	}

	public ObjectProperty<Payment> paymentProperty() {
		return this.payment;
	}

	public Payment getPayment() {
		return this.paymentProperty().get();
	}

	public void setPayment(final Payment payment) {
		this.paymentProperty().set(payment);
	}

	public BooleanProperty deletedProperty() {
		return this.deleted;
	}

	public boolean isDeleted() {
		return this.deletedProperty().get();
	}

	public void setDeleted(final boolean deleted) {
		this.deletedProperty().set(deleted);
	}

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

}