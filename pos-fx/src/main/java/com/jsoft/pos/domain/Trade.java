package com.jsoft.pos.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jsoft.pos.util.DateDeSerializer;
import com.jsoft.pos.util.DateSerializer;

@SuppressWarnings("serial")
public abstract class Trade implements Serializable {

	private long id;
	@JsonSerialize(using = DateSerializer.class)
	@JsonDeserialize(using = DateDeSerializer.class)
	private LocalDate eventDate;
	private String remark;
	private List<TradeDetail> tradeDetail;
	private Employee employee;
	private Payment payment;

	private boolean deleted;
	private Security security;

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

	public List<TradeDetail> getTradeDetail() {
		return tradeDetail;
	}

	public void setTradeDetail(List<TradeDetail> tradeDetail) {
		this.tradeDetail = tradeDetail;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

}