package com.jsoft.pos.repo.retrofit.impl;

import java.io.IOException;
import java.util.List;

import com.jsoft.pos.domain.Invoice;
import com.jsoft.pos.repo.InvoiceRepo;
import com.jsoft.pos.service.InvoiceService;
import com.jsoft.pos.util.RepositoryException;
import com.jsoft.pos.util.RetrofitSingleton;
import com.jsoft.pos.util.ServerStatus;

import retrofit2.Response;

public class InvoiceRepoImpl implements InvoiceRepo {
	
	private InvoiceService service;

	public InvoiceRepoImpl() {
		service = RetrofitSingleton.getInstance().create(InvoiceService.class);
	}

	@Override
	public List<Invoice> search(String dateFrom, String dateTo, int offset, int limit) {
		try {
			Response<List<Invoice>> resp = service.search(dateFrom, dateTo, offset, limit).execute();
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
	public Long count(String dateFrom, String dateTo) {
		try {
			Response<Long> resp = service.count(dateFrom, dateTo).execute();
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
	public Invoice findById(long id) {
		try {
			Response<Invoice> resp = service.findById(id).execute();
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
	public String save(Invoice invoice) {
		try {
			Response<String> resp = service.save(invoice).execute();
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
