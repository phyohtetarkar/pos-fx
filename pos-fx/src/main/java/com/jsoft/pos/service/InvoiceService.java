package com.jsoft.pos.service;

import java.util.List;

import com.jsoft.pos.domain.Invoice;

import retrofit2.Call;

public interface InvoiceService {

	Call<List<Invoice>> search();
	
	Call<Long> count();
	
	Call<Invoice> findById(long id);
	
	Call<String> save(Invoice Invoice);
}
