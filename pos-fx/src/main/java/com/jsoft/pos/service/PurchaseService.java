package com.jsoft.pos.service;

import java.util.List;

import com.jsoft.pos.domain.Purchase;

import retrofit2.Call;

public interface PurchaseService {

	Call<List<Purchase>> search();
	
	Call<Long> count();
	
	Call<Purchase> findById(long id);
	
	Call<String> save(Purchase purchase);
}
