package com.jsoft.pos.repo;

import java.util.List;

import com.jsoft.pos.domain.Invoice;

public interface InvoiceRepo {

	List<Invoice> search(String dateFrom, String dateTo, int offset, int limit);
	
	Long count(String dateFrom, String dateTo);
	
	Invoice findById(long id);
	
	String save(Invoice invoice);
	
}
