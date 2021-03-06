package com.jsoft.pos.service;

import java.util.List;

import com.jsoft.pos.domain.Sale;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SaleService {
	
	@GET("sale/search")
	Call<List<Sale>> search(@Query("dateFrom") String dateFrom, 
			@Query("dateTo") String dateTo,
			@Query("employeeId") int employeeId,
			@Query("offset") int offset,
			@Query("limit") int limit);
	
	@GET("sale/count")
	Call<Long> count(@Query("dateFrom") String dateFrom, 
			@Query("dateTo") String dateTo,
			@Query("employeeId") int employeeId);
	
	@GET("sale/{id}")
	Call<Sale> findById(@Path("id") long id);
	
	@POST("sale")
	Call<String> save(@Body Sale sale);
}
