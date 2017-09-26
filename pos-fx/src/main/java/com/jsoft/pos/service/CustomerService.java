package com.jsoft.pos.service;

import java.util.List;

import com.jsoft.pos.domain.Customer;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CustomerService {

	@GET("customer/search")
	Call<List<Customer>> search(@Query("name") String name, 
			@Query("name") int offset, 
			@Query("name") int limit);
	
	@GET("customer/count")
	Call<Long> count(@Query("name") String name);
	
	@GET("customer/{id}")
	Call<Customer> findById(@Path("id") int id);
	
	@POST("customer")
	Call<String> save(@Body Customer customer);
}
