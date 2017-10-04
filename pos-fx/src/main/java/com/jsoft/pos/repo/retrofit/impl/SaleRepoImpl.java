package com.jsoft.pos.repo.retrofit.impl;

import java.io.IOException;
import java.util.List;

import com.jsoft.pos.domain.Sale;
import com.jsoft.pos.repo.SaleRepo;
import com.jsoft.pos.service.SaleService;
import com.jsoft.pos.util.RepositoryException;
import com.jsoft.pos.util.RetrofitSingleton;
import com.jsoft.pos.util.ServerStatus;

import retrofit2.Response;

public class SaleRepoImpl implements SaleRepo {
	
	private SaleService service;

	public SaleRepoImpl() {
		service = RetrofitSingleton.getInstance().create(SaleService.class);
	}

	@Override
	public List<Sale> search(String dateFrom, String dateTo, int employeeId, int offset, int limit) {
		try {
			Response<List<Sale>> resp = service.search(dateFrom, dateTo, employeeId, offset, limit).execute();
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
	public Sale findById(long id) {
		try {
			Response<Sale> resp = service.findById(id).execute();
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
	public String save(Sale sale) {
		try {
			Response<String> resp = service.save(sale).execute();
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
