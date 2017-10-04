package com.jsoft.pos.repo;

import java.util.List;

import com.jsoft.pos.domain.Customer;

public interface CustomerRepo {

	List<Customer> search(String name, int offset, int limit);
	
	Long count(String name);
	
	Customer findById(int id);
	
	String save(Customer customer);
	
}
