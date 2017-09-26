package com.jsoft.pos.service;

import java.util.List;

import com.jsoft.pos.domain.Purchase;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PurchaseService {

	@GET("purchase/search")
	Call<List<Purchase>> search(@Query("dateFrom") String dateFrom, 
			@Query("dateTo") String dateTo,
			@Query("employeeId") int employeeId,
			@Query("offset") int offset,
			@Query("limit") int limit);
	
	@GET("purchase/count")
	Call<Long> count(@Query("dateFrom") String dateFrom, 
			@Query("dateTo") String dateTo,
			@Query("employeeId") int employeeId);
	
	@GET("purchase/{id}")
	Call<Purchase> findById(@Path("id") long id);
	
	@POST("purchase")
	Call<String> save(@Body Purchase purchase);
	
}
