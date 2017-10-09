package com.jsoft.pos.repo.retrofit;

import java.io.IOException;
import java.util.List;

import com.jsoft.pos.domain.Counter;
import com.jsoft.pos.repo.CounterRepo;
import com.jsoft.pos.service.CounterService;
import com.jsoft.pos.util.ApplicationException;
import com.jsoft.pos.util.RetrofitSingleton;
import com.jsoft.pos.util.ServerStatus;

import retrofit2.Response;

public class CounterRepoImpl implements CounterRepo {
	
	private CounterService service;
	
	public CounterRepoImpl() {
		service = RetrofitSingleton.getInstance().create(CounterService.class);
	}

	@Override
	public List<Counter> findAll() {
		try {
			Response<List<Counter>> resp = service.findAll().execute();
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
	public Counter findById(int id) {
		try {
			Response<Counter> resp = service.findById(id).execute();
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
	public String save(Counter counter) {
		try {
			Response<String> resp = service.save(counter).execute();
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
