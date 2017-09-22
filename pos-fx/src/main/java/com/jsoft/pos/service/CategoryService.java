package com.jsoft.pos.service;

import java.util.List;

import com.jsoft.pos.domain.Category;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CategoryService {
	
	@GET("category")
	Call<List<Category>> findAll();
	
	@GET("category/{id}")
	Call<Category> findById(@Path("id") int id);
	
	Call<List<Category>> findByName(String name);
	
	@POST("category")
	Call<String> save(@Body Category category);
}
