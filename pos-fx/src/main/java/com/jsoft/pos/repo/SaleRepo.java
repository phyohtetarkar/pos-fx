package com.jsoft.pos.repo;

import java.util.List;

import com.jsoft.pos.domain.Sale;

public interface SaleRepo {

	List<Sale> search(String dateFrom, String dateTo, int employeeId, int offset, int limit);
	
	Long count(String dateFrom, String dateTo, int employeeId);
	
	Sale findById(long id);
	
	String save(Sale sale);
	
}
