package com.jsoft.pos.repo;

import java.util.List;

import com.jsoft.pos.domain.Category;

public interface CategoryRepo {

	List<Category> findAll();
	
	Category findById(int id);
	
	String save(Category category);
	
}
