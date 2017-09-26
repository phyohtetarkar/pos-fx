package com.jsoft.pos.view.model;

import java.util.List;

import com.jsoft.pos.domain.Category;
import com.jsoft.pos.domain.Item;
import com.jsoft.pos.service.CategoryService;
import com.jsoft.pos.service.ItemService;
import com.jsoft.pos.util.AlertUtil;
import com.jsoft.pos.util.RetrofitSingleton;
import com.jsoft.pos.util.ServerStatus;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemsViewModel extends PagableViewModel<Item> {

	private ListProperty<Category> categories = new SimpleListProperty<>();

	private CategoryService catService;
	private ItemService service;

	private ObjectProperty<Category> category = new SimpleObjectProperty<>();
	private StringProperty code = new SimpleStringProperty();
	private StringProperty name = new SimpleStringProperty();

	public ItemsViewModel() {
		catService = RetrofitSingleton.getInstance().create(CategoryService.class);
		service = RetrofitSingleton.getInstance().create(ItemService.class);
	}

	public void init() {
		if (ServerStatus.isReachable()) {
			loadCategories();
			search();
		} else {
			AlertUtil.queueToast(ServerStatus.CONNECTION_ERROR);
		}

	}

	public void search() {
		if (ServerStatus.isReachable()) {
			loading.set(true);
			service.count(code.get(), name.get(), category.get() == null ? 0 : category.get().getId())
					.enqueue(countCallBack());

		} else {
			AlertUtil.queueToast(ServerStatus.CONNECTION_ERROR);
		}
	}

	@Override
	public void loadValues() {
		int offset = currentPage.get() * LIMIT;

		if (!loading.get()) {
			loading.set(true);
		}

		service.search(code.get(), name.get(), category.get() == null ? 0 : category.get().getId(), offset, LIMIT)
				.enqueue(valuesCallBack());
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

	public ObjectProperty<Category> categoryProperty() {
		return category;
	}

	public StringProperty codeProperty() {
		return code;
	}

	public StringProperty nameProperty() {
		return name;
	}

}
