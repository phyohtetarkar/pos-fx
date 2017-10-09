package com.jsoft.pos.repo.retrofit;

import java.io.IOException;
import java.util.List;

import com.jsoft.pos.domain.Category;
import com.jsoft.pos.repo.CategoryRepo;
import com.jsoft.pos.service.CategoryService;
import com.jsoft.pos.util.ApplicationException;
import com.jsoft.pos.util.RetrofitSingleton;
import com.jsoft.pos.util.ServerStatus;

import retrofit2.Response;

public class CategoryRepoImpl implements CategoryRepo {
	
	private CategoryService service;
	
	public CategoryRepoImpl() {
		service = RetrofitSingleton.getInstance().create(CategoryService.class);
	}

	@Override
	public List<Category> findAll() {
		try {
			Response<List<Category>> resp = service.findAll().execute();
			if (!resp.isSuccessful()) {
				throw new ApplicationException(resp.errorBody().string());
			} 
			
			return resp.body();
		} catch (IOException e) {
			e.printStackTrace();
			throw new ApplicationException(ServerStatus.CONNECTION_ERROR);
		}
	}

	@Override
	public Category findById(int id) {
		try {
			Response<Category> resp = service.findById(id).execute();
			if (!resp.isSuccessful()) {
				throw new ApplicationException(resp.errorBody().string());
			} 
			
			return resp.body();
		} catch (IOException e) {
			e.printStackTrace();
			throw new ApplicationException(ServerStatus.CONNECTION_ERROR);
		}
	}

	@Override
	public String save(Category category) {
		try {
			Response<String> resp = service.save(category).execute();
			if (!resp.isSuccessful()) {
				throw new ApplicationException(resp.errorBody().string());
			} 
			
			return resp.body();
		} catch (IOException e) {
			e.printStackTrace();
			throw new ApplicationException(ServerStatus.CONNECTION_ERROR);
		}
	}
	
}
