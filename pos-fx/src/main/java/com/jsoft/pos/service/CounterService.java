package com.jsoft.pos.service;

import java.util.List;

import com.jsoft.pos.domain.Counter;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CounterService {

	@GET("counter")
	Call<List<Counter>> findAll();
	
	@GET("counter/{id}")
	Call<Counter> findById(@Path("id") int id);
	
	@POST("counter")
	Call<String> save(@Body Counter counter);
	
}
