package com.jsoft.pos.view.model;

import java.time.LocalDateTime;

import com.jsoft.pos.domain.Payment;
import com.jsoft.pos.service.PaymentService;
import com.jsoft.pos.util.AlertUtil;
import com.jsoft.pos.util.RetrofitSingleton;
import com.jsoft.pos.util.ServerStatus;

public class PaymentsViewModel extends SinglePageViewModel<Payment> {
	
	private PaymentService service;
	
	public PaymentsViewModel() {
		service = RetrofitSingleton.getInstance().create(PaymentService.class);
	}

	@Override
	public void load() {
		if (ServerStatus.isReachable()) {
			loading.set(true);
			service.findAll().enqueue(listCallBack());
		} else {
			AlertUtil.queueToast(ServerStatus.CONNECTION_ERROR);
		}
		
	}
	
	public void delete(Payment payment) {
		if (AlertUtil.showConfirm("Are you sure to delete?")) {
			payment.setDeleted(true);
			save(payment);
		}
	}
	
	public void save(Payment payment) {
		if (ServerStatus.isReachable()) {
			payment.getSecurity().setCreation(LocalDateTime.now());
			payment.getSecurity().setModification(LocalDateTime.now());
			
			service.save(payment).enqueue(saveCallBack());
		} else {
			AlertUtil.queueToast(ServerStatus.CONNECTION_ERROR);
		}
		
	}
	
}
