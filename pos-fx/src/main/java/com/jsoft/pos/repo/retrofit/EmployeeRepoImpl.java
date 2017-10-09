package com.jsoft.pos.repo.retrofit;

import java.io.IOException;
import java.util.List;

import com.jsoft.pos.domain.Employee;
import com.jsoft.pos.repo.EmployeeRepo;
import com.jsoft.pos.service.EmployeeService;
import com.jsoft.pos.util.ApplicationException;
import com.jsoft.pos.util.RetrofitSingleton;
import com.jsoft.pos.util.ServerStatus;

import retrofit2.Response;

public class EmployeeRepoImpl implements EmployeeRepo {
	
	private EmployeeService service;

	public EmployeeRepoImpl() {
		service = RetrofitSingleton.getInstance().create(EmployeeService.class);
	}

	@Override
	public List<Employee> search(String name, int offset, int limit) {
		try {
			Response<List<Employee>> resp = service.search(name, offset, limit).execute();
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
	public Employee findById(int id) {
		try {
			Response<Employee> resp = service.findById(id).execute();
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
	public String save(Employee employee) {
		try {
			Response<String> resp = service.save(employee).execute();
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
