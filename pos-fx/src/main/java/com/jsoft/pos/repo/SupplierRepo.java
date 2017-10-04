package com.jsoft.pos.repo;

import java.util.List;

import com.jsoft.pos.domain.Supplier;

public interface SupplierRepo {

	List<Supplier> search(String name, int offset, int limit);
	
	Long count(String name);
	
	Supplier findById(int id);
	
	String save(Supplier supplier);
	
}
