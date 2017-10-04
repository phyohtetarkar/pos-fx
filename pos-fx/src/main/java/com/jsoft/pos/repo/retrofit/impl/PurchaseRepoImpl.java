package com.jsoft.pos.repo.retrofit.impl;

import java.io.IOException;
import java.util.List;

import com.jsoft.pos.domain.Purchase;
import com.jsoft.pos.repo.PurchaseRepo;
import com.jsoft.pos.service.PurchaseService;
import com.jsoft.pos.util.RepositoryException;
import com.jsoft.pos.util.RetrofitSingleton;
import com.jsoft.pos.util.ServerStatus;

import retrofit2.Response;

public class PurchaseRepoImpl implements PurchaseRepo {
	
	private PurchaseService service;

	public PurchaseRepoImpl() {
		service = RetrofitSingleton.getInstance().create(PurchaseService.class);
	}

	@Override
	public List<Purchase> search(String dateFrom, String dateTo, int employeeId, int offset, int limit) {
		try {
			Response<List<Purchase>> resp = service.search(dateFrom, dateTo, employeeId, offset, limit).execute();
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
	public Long count(String dateFrom, String dateTo, int employeeId) {
		try {
			Response<Long> resp = service.count(dateFrom, dateTo, employeeId).execute();
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
	public Purchase findById(long id) {
		try {
			Response<Purchase> resp = service.findById(id).execute();
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
	public String save(Purchase purchase) {
		try {
			Response<String> resp = service.save(purchase).execute();
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
