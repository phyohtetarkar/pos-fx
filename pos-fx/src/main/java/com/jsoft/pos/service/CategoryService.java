package com.jsoft.pos.service;

import java.util.List;

import com.jsoft.pos.domain.Category;

import retrofit2.Call;

public interface CategoryService {
	
	Call<List<Category>> findAll();
	
	Call<Category> findById(int id);
	
	Call<List<Category>> findByName(String name);
	
	Call<String> save(Category category);
}
