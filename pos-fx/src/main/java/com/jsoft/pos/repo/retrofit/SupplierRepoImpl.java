package com.jsoft.pos.repo.retrofit;

import java.io.IOException;
import java.util.List;

import com.jsoft.pos.domain.Supplier;
import com.jsoft.pos.repo.SupplierRepo;
import com.jsoft.pos.service.SupplierService;
import com.jsoft.pos.util.ApplicationException;
import com.jsoft.pos.util.RetrofitSingleton;
import com.jsoft.pos.util.ServerStatus;

import retrofit2.Response;

public class SupplierRepoImpl implements SupplierRepo {
	
	private SupplierService service;

	public SupplierRepoImpl() {
		service = RetrofitSingleton.getInstance().create(SupplierService.class);
	}

	@Override
	public List<Supplier> search(String name, int offset, int limit) {
		try {
			Response<List<Supplier>> resp = service.search(name, offset, limit).execute();
			if (!resp.isSuccessful()) {
				throw new ApplicationException(resp.errorBody().string());
			} 
			
			return resp.body();
		} catch (IOException e) {
			e.printStackTrace();
			throw new ApplicationException(ServerStatus.CONNECTION_ERROR);
		}
	}

	@Override
	public Long count(String name) {
		try {
			Response<Long> resp = service.count(name).execute();
			if (!resp.isSuccessful()) {
				throw new ApplicationException(resp.errorBody().string());
			} 
			
			return resp.body();
		} catch (IOException e) {
			e.printStackTrace();
			throw new ApplicationException(ServerStatus.CONNECTION_ERROR);
		}
	}

	@Override
	public Supplier findById(int id) {
		try {
			Response<Supplier> resp = service.findById(id).execute();
			if (!resp.isSuccessful()) {
				throw new ApplicationException(resp.errorBody().string());
			} 
			
			return resp.body();
		} catch (IOException e) {
			e.printStackTrace();
			throw new ApplicationException(ServerStatus.CONNECTION_ERROR);
		}
	}

	@Override
	public String save(Supplier supplier) {
		try {
			Response<String> resp = service.save(supplier).execute();
			if (!resp.isSuccessful()) {
				throw new ApplicationException(resp.errorBody().string());
			} 
			
			return resp.body();
		} catch (IOException e) {
			e.printStackTrace();
			throw new ApplicationException(ServerStatus.CONNECTION_ERROR);
		}
	}

}
