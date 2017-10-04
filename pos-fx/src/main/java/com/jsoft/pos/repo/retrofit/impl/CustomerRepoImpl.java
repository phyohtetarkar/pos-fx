package com.jsoft.pos.repo.retrofit.impl;

import java.io.IOException;
import java.util.List;

import com.jsoft.pos.domain.Customer;
import com.jsoft.pos.repo.CustomerRepo;
import com.jsoft.pos.service.CustomerService;
import com.jsoft.pos.util.RepositoryException;
import com.jsoft.pos.util.RetrofitSingleton;
import com.jsoft.pos.util.ServerStatus;

import retrofit2.Response;

public class CustomerRepoImpl implements CustomerRepo {
	
	private CustomerService service;

	public CustomerRepoImpl() {
		service = RetrofitSingleton.getInstance().create(CustomerService.class);
	}

	@Override
	public List<Customer> search(String name, int offset, int limit) {
		try {
			Response<List<Customer>> resp = service.search(name, offset, limit).execute();
			if (!resp.isSuccessful()) {
				throw new RepositoryException(resp.errorBody().string());
			} 
			
			return resp.body();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RepositoryException(ServerStatus.CONNECTION_ERROR);
		}
	}

	@Override
	public Long count(String name) {
		try {
			Response<Long> resp = service.count(name).execute();
			if (!resp.isSuccessful()) {
				throw new RepositoryException(resp.errorBody().string());
			} 
			
			return resp.body();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RepositoryException(ServerStatus.CONNECTION_ERROR);
		}
	}

	@Override
	public Customer findById(int id) {
		try {
			Response<Customer> resp = service.findById(id).execute();
			if (!resp.isSuccessful()) {
				throw new RepositoryException(resp.errorBody().string());
			} 
			
			return resp.body();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RepositoryException(ServerStatus.CONNECTION_ERROR);
		}
	}

	@Override
	public String save(Customer customer) {
		try {
			Response<String> resp = service.save(customer).execute();
			if (!resp.isSuccessful()) {
				throw new RepositoryException(resp.errorBody().string());
			} 
			
			return resp.body();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RepositoryException(ServerStatus.CONNECTION_ERROR);
		}
	}

}
