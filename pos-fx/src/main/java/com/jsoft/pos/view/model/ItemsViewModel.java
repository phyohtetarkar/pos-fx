package com.jsoft.pos.view.model;

import java.util.List;

import com.jsoft.pos.domain.Category;
import com.jsoft.pos.service.CategoryService;
import com.jsoft.pos.service.ItemService;
import com.jsoft.pos.util.AlertUtil;
import com.jsoft.pos.util.RetrofitSingleton;
import com.jsoft.pos.util.ServerStatus;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemsViewModel {
	
	private ListProperty<Category> categories = new SimpleListProperty<>();
	private BooleanProperty loading = new SimpleBooleanProperty();
	
	private CategoryService catService;
	@SuppressWarnings("unused")
	private ItemService service;
	
	private ObjectProperty<Category> category = new SimpleObjectProperty<>();
	private StringProperty code = new SimpleStringProperty();
	private StringProperty name = new SimpleStringProperty();
	private IntegerProperty page = new SimpleIntegerProperty();
	private IntegerProperty currentPage = new SimpleIntegerProperty();

	public ItemsViewModel() {
		catService = RetrofitSingleton.getInstance().create(CategoryService.class);
		service = RetrofitSingleton.getInstance().create(ItemService.class);
	}
	
	public void init() {
		if (ServerStatus.isReachable()) {
			loadCategories();
			count();
		} else {
			AlertUtil.queueToast(ServerStatus.CONNECTION_ERROR);
		}
		
	}
	
	public void search() {
		System.out.println(category.get());
		System.out.println(code.get());
		System.out.println(name.get());
		System.out.println(currentPage.get());
	}
	
	private void count() {
		
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
	
	public final ListProperty<Category> categoriesProperty() {
		return categories;
	}
	
	public final BooleanProperty loadingProperty() {
		return loading;
	}

	public ObjectProperty<Category> categoryProperty() {
		return this.category;
	}

	public StringProperty codeProperty() {
		return this.code;
	}

	public StringProperty nameProperty() {
		return this.name;
	}
	
	public IntegerProperty pageProperty() {
		return this.page;
	}
	public IntegerProperty currentPageProperty() {
		return this.currentPage;
	}
}
