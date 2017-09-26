package com.jsoft.pos.service;

import java.util.List;

import com.jsoft.pos.domain.Invoice;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface InvoiceService {

	@GET("invoice/search")
	Call<List<Invoice>> search(@Query("dateFrom") String dateFrom, 
			@Query("dateTo") String dateTo,
			@Query("offset") int offset,
			@Query("limit") int limit);
	
	@GET("invoice/count")
	Call<Long> count(@Query("dateFrom") String dateFrom, 
			@Query("dateTo") String dateTo);
	
	@GET("invoice/{id}")
	Call<Invoice> findById(@Path("id") long id);
	
	@POST("invoice")
	Call<String> save(@Body Invoice Invoice);
}
