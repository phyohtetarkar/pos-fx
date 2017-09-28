package com.jsoft.pos.view.model;

import java.time.LocalDateTime;

import com.jsoft.pos.domain.Category;
import com.jsoft.pos.service.CategoryService;
import com.jsoft.pos.util.AlertUtil;
import com.jsoft.pos.util.RetrofitSingleton;
import com.jsoft.pos.util.ServerStatus;

public class CategoriesViewModel extends SinglePageViewModel<Category> {
	
	private CategoryService service;
	
	public CategoriesViewModel() {
		service = RetrofitSingleton.getInstance().create(CategoryService.class);
	}

	@Override
	public void load() {
		if (ServerStatus.isReachable()) {
			loading.set(true);
			service.findAll().enqueue(listCallBack());
		} else {
			AlertUtil.queueToast(ServerStatus.CONNECTION_ERROR);
		}
	}
	
	public void delete(Category category) {
		if (AlertUtil.showConfirm("Are you sure to delete?")) {
			category.setDeleted(true);
			save(category);
		}
	}
	
	public void save(Category category) {
		if (ServerStatus.isReachable()) {
			category.getSecurity().setCreation(LocalDateTime.now());
			category.getSecurity().setModification(LocalDateTime.now());
			
			service.save(category).enqueue(saveCallBack());
			
		} else {
			AlertUtil.queueToast(ServerStatus.CONNECTION_ERROR);
		}
		
	}
	
}
