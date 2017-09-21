package com.jsoft.pos.service;

import java.util.List;

import com.jsoft.pos.domain.Supplier;

import retrofit2.Call;

public interface SupplierService {

	Call<List<Supplier>> search();
	
	Call<Supplier> findById(int id);
	
	Call<String> save(Supplier supplier);
}
