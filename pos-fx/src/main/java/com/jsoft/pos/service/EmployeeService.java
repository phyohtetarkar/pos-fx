package com.jsoft.pos.service;

import java.util.List;

import com.jsoft.pos.domain.Employee;

import retrofit2.Call;

public interface EmployeeService {

	Call<List<Employee>> search();
	
	Call<Employee> findById(int id);
	
	Call<String> save(Employee employee);
}
