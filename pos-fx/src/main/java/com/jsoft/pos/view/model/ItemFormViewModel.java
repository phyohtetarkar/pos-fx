package com.jsoft.pos.view.model;

import java.util.List;

import com.jsoft.pos.domain.Category;
import com.jsoft.pos.domain.Item;
import com.jsoft.pos.domain.wrapper.ItemWrapper;
import com.jsoft.pos.service.CategoryService;
import com.jsoft.pos.service.ItemService;
import com.jsoft.pos.util.AlertUtil;
import com.jsoft.pos.util.RetrofitSingleton;
import com.jsoft.pos.util.ServerStatus;

import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemFormViewModel {
	private ListProperty<Category> categories = new SimpleListProperty<>();
	private BooleanProperty loading = new SimpleBooleanProperty();
	
	private ItemWrapper wrapper;
	private ItemService service;
	private CategoryService catService;
	private OnFinishedListener onFinishedListener;

	public ItemFormViewModel() {
		wrapper = new ItemWrapper();
		service = RetrofitSingleton.getInstance().create(ItemService.class);
		catService = RetrofitSingleton.getInstance().create(CategoryService.class);
	}
	
	public void init() {
		loadCategories();
	}
	
	public void save() {
		if (ServerStatus.isReachable()) {
			loading.set(true);
			Item item = wrapper.build();
			service.save(item).enqueue(new Callback<String>() {
				
				@Override
				public void onResponse(Call<String> call, Response<String> resp) {
					Platform.runLater(() -> loading.set(false));
					if (resp.isSuccessful()) {
						AlertUtil.queueToast(resp.body());
						if (onFinishedListener != null) {
							Platform.runLater(onFinishedListener::finished);
						}
					}
				}
				
				@Override
				public void onFailure(Call<String> call, Throwable t) {
					t.printStackTrace();
					loading.set(false);
					AlertUtil.queueToast(t.getMessage());
				}
			});
		} else {
			AlertUtil.queueToast(ServerStatus.CONNECTION_ERROR);
		}
		
	}
	
	private void loadCategories() {
		if (ServerStatus.isReachable()) {
			catService.findAll().enqueue(new Callback<List<Category>>() {

				@Override
				public void onResponse(Call<List<Category>> call, Response<List<Category>> resp) {
					if (resp.isSuccessful()) {
						categories.set(FXCollections.observableArrayList(resp.body()));
					}
				}

				@Override
				public void onFailure(Call<List<Category>> call, Throwable t) {
					t.printStackTrace();
					AlertUtil.queueToast(t.getMessage());
				}
			});
		} else {
			AlertUtil.queueToast(ServerStatus.CONNECTION_ERROR);
		}

	}
	
	public void setOnSaveCompleteListener(OnFinishedListener onSaveCompleteListener) {
		this.onFinishedListener = onSaveCompleteListener;
	}
	
	public final ItemWrapper itemWrapper() {
		return wrapper;
	}
	
	public final ListProperty<Category> categoriesProperty() {
		return categories;
	}
	
	public final BooleanProperty loadingProperty() {
		return loading;
	}
	
}
