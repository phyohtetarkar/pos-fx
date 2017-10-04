package com.jsoft.pos.repo;

import java.util.List;

import com.jsoft.pos.domain.Employee;

public interface EmployeeRepo {

	List<Employee> search(String name, int offset, int limit);
	
	Long count(String name);
	
	Employee findById(int id);
	
	String save(Employee employee);
	
}
