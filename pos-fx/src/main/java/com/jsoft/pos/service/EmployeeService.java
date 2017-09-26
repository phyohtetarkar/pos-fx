package com.jsoft.pos.service;

import java.util.List;

import com.jsoft.pos.domain.Employee;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EmployeeService {

	@GET("employee/search")
	Call<List<Employee>> search(@Query("name") String name, 
			@Query("name") int offset, 
			@Query("name") int limit);
	
	@GET("employee/count")
	Call<Long> count(@Query("name") String name);
	
	@GET("employee/{id}")
	Call<Employee> findById(@Path("id") int id);
	
	@POST("employee")
	Call<String> save(@Body Employee employee);
}
