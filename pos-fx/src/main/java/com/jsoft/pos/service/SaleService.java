package com.jsoft.pos.service;

import java.util.List;

import com.jsoft.pos.domain.Sale;

import retrofit2.Call;

public interface SaleService {
	
	Call<List<Sale>> search();
	
	Call<Long> count();
	
	Call<Sale> findById(long id);
	
	Call<String> save(Sale sale);
}
