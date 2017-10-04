package com.jsoft.pos.repo;

import java.util.List;

import com.jsoft.pos.domain.Counter;

public interface CounterRepo {

	List<Counter> findAll();
	
	Counter findById(int id);
	
	String save(Counter counter);
	
}
