package com.jsoft.pos.repo;

import java.util.List;

import com.jsoft.pos.domain.Purchase;

public interface PurchaseRepo {

	List<Purchase> search(String dateFrom, String dateTo, int employeeId, int offset, int limit);
	
	Long count(String dateFrom, String dateTo, int employeeId);
	
	Purchase findById(long id);
	
	String save(Purchase purchase);
	
}
