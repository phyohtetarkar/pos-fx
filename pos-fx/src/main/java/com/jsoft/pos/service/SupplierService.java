package com.jsoft.pos.service;

import java.util.List;

import com.jsoft.pos.domain.Supplier;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SupplierService {

	@GET("supplier/search")
	Call<List<Supplier>> search(@Query("name") String name, 
			@Query("name") int offset, 
			@Query("name") int limit);
	
	@GET("supplier/count")
	Call<Long> count(@Query("name") String name);
	
	@GET("supplier/{id}")
	Call<Supplier> findById(@Path("id") int id);
	
	@POST("supplier")
	Call<String> save(@Body Supplier suppllier);
}
