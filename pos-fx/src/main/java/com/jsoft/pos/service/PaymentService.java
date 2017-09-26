package com.jsoft.pos.service;

import java.util.List;

import com.jsoft.pos.domain.Payment;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PaymentService {

	@GET("payment")
	Call<List<Payment>> findAll();
	
	@GET("payment/{id}")
	Call<Payment> findById(@Path("id") int id);
	
	@POST("payment")
	Call<String> save(@Body Payment payment);
}
