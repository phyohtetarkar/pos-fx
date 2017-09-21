package com.jsoft.pos.domain.wrapper;

import java.time.LocalDate;
import java.util.Set;

public abstract class TradeWrapper {

	private long id;
	private LocalDate eventDate;
	private String remark;
	private Set<TradeDetailWrapper> tradeDetail;
	private EmployeeWrapper employee;
	private PaymentWrapper payment;

	private boolean deleted;
	private SecurityWrapper security;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set<TradeDetailWrapper> getTradeDetail() {
		return tradeDetail;
	}

	public void setTradeDetail(Set<TradeDetailWrapper> tradeDetail) {
		this.tradeDetail = tradeDetail;
	}

	public EmployeeWrapper getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeWrapper employee) {
		this.employee = employee;
	}

	public PaymentWrapper getPayment() {
		return payment;
	}

	public void setPayment(PaymentWrapper payment) {
		this.payment = payment;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public SecurityWrapper getSecurity() {
		return security;
	}

	public void setSecurity(SecurityWrapper security) {
		this.security = security;
	}

}