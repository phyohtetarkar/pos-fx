package com.jsoft.pos.service;

import java.util.List;

import com.jsoft.pos.domain.Payment;

import retrofit2.Call;

public interface PaymentService {

	Call<List<Payment>> findAll();
	
	Call<Payment> findById(int id);
	
	Call<String> save(Payment payment);
}
