package com.jsoft.pos.service;

import java.util.List;

import com.jsoft.pos.domain.Customer;

import retrofit2.Call;

public interface CustomerService {

	Call<List<Customer>> search();
	
	Call<Customer> findById(int id);
	
	Call<String> save(Customer customer);
}
