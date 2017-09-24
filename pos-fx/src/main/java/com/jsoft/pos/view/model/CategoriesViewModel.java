package com.jsoft.pos.view.model;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.jsoft.pos.domain.Category;
import com.jsoft.pos.service.CategoryService;
import com.jsoft.pos.util.AlertUtil;
import com.jsoft.pos.util.RetrofitSingleton;
import com.jsoft.pos.util.ServerStatus;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesViewModel {
	
	private CategoryService service;
	private List<Category> list;
	
	private ListProperty<Category> categories = new SimpleListProperty<>();
	private BooleanProperty loading = new SimpleBooleanProperty();
	
	public CategoriesViewModel() {
		service = RetrofitSingleton.getInstance().create(CategoryService.class);
	}

	public void load() {
		
		if (ServerStatus.isReachable()) {
			loading.set(true);
			service.findAll().enqueue(new Callback<List<Category>>() {
				
				@Override
				public void onResponse(Call<List<Category>> call, Response<List<Category>> resp) {
					loading.set(false);
					if (resp.isSuccessful()) {
						list = resp.body();
						categories.set(FXCollections.observableArrayList(list));
					} else {
						System.out.println(resp.code());
					}
				}
				
				@Override
				public void onFailure(Call<List<Category>> call, Throwable t) {
					t.printStackTrace();
					loading.set(false);
					AlertUtil.queueToast(t.getMessage());
				}
			});
		} else {
			AlertUtil.queueToast(ServerStatus.CONNECTION_ERROR);
		}
		
	}
	
	public void filter(String text) {
		if (null != list) {
			categories.set(FXCollections.observableArrayList(
					list.stream()
					.filter(c -> c.getName().toLowerCase().contains(text))
					.collect(Collectors.toList())));
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
			
			service.save(category).enqueue(new Callback<String>() {

				@Override
				public void onResponse(Call<String> call, Response<String> resp) {
					if (resp.isSuccessful()) {
						AlertUtil.queueToast(resp.body());
						load();
					} else {
						try {
							System.out.println(resp.errorBody().string());
						} catch (IOException e) {
							e.printStackTrace();
						}
					} 
				}
				
				@Override
				public void onFailure(Call<String> call, Throwable t) {
					t.printStackTrace();
					AlertUtil.queueToast(t.getMessage());
				}

			});
		} else {
			AlertUtil.queueToast(ServerStatus.CONNECTION_ERROR);
		}
		
	}
	
	public final ListProperty<Category> categoriesProperty() {
		return categories;
	}
	
	public final BooleanProperty loadingProperty() {
		return loading;
	}
	
}
