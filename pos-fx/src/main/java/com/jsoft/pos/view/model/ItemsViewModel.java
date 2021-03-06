package com.jsoft.pos.view.model;

import java.util.List;

import com.jsoft.pos.domain.Category;
import com.jsoft.pos.domain.Item;
import com.jsoft.pos.repo.CategoryRepo;
import com.jsoft.pos.repo.ItemRepo;
import com.jsoft.pos.util.GlobalExecutor;
import com.jsoft.pos.util.RepositoryFactory;
import com.jsoft.pos.util.RepositoryFactory.Provider;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;

public class ItemsViewModel extends PagableViewModel<Item> {

	private ListProperty<Category> categories = new SimpleListProperty<>();

	private ObjectProperty<Category> category = new SimpleObjectProperty<>();
	private StringProperty code = new SimpleStringProperty();
	private StringProperty name = new SimpleStringProperty();
	
	private ItemRepo repo;
	private CategoryRepo catRepo;

	public ItemsViewModel() {
		repo = RepositoryFactory.create(ItemRepo.class, Provider.RETROFIT);
		catRepo = RepositoryFactory.create(CategoryRepo.class, Provider.RETROFIT);
	}

	@Override
	public void init() {
		loadCategories();
		search();
	}

	@Override
	public void search() {
		Task<Long> task = new Task<Long>() {
			@Override
			protected Long call() throws Exception {
				return repo.count(code.get(), name.get(), category.get() != null ? category.get().getId() : 0);
			}
		};
		
		task.setOnSucceeded(evt -> {
			count = task.getValue().intValue();
			page.set(Math.round((float)count / limit));
			searchPage();
		});
		
		task.setOnFailed(evt -> {
			pushMessage(task.getException().getMessage());
			loading.unbind();
		});
		
		GlobalExecutor.get().submit(task);
	}

	@Override
	public void searchPage() {
		Task<List<Item>> task = new Task<List<Item>>() {
			@Override
			protected List<Item> call() throws Exception {
				int offset = currentPage.get() * limit;
				return repo.search(code.get(), name.get(), category.get() != null ? category.get().getId() : 0, offset, limit);
			}
		};
		
		loading.bind(task.runningProperty());
		
		task.setOnSucceeded(evt -> {
			list.clear();
			list.set(FXCollections.observableArrayList(task.getValue()));
			loading.unbind();
			
			int offset = currentPage.get() * limit;
			int range = offset + list.size();
			pageInfo.set(String.format("Showing %d to %d of %d", offset + 1, 
					list.size() > 0 ? range : 0, count));
		});
		
		task.setOnFailed(evt -> {
			pushMessage(task.getException().getMessage());
			loading.unbind();
		});
		
		GlobalExecutor.get().submit(task);
	}

	private void loadCategories() {
		Task<List<Category>> task = new Task<List<Category>>() {
			@Override
			protected List<Category> call() throws Exception {
				return catRepo.findAll();
			}
		};
		
		task.setOnSucceeded(evt -> {
			categories.set(FXCollections.observableArrayList(task.getValue()));
		});
		
		task.setOnFailed(evt -> {
			pushMessage(task.getException().getMessage());
		});
		
		GlobalExecutor.get().submit(task);

	}
	
	
	public void delete(Item item) {
		item.setDeleted(true);
		
		Task<String> task = new Task<String>() {
			@Override
			protected String call() throws Exception {
				return repo.save(item);
			}
		};
		
		loading.bind(task.runningProperty());
		
		task.setOnSucceeded(evt -> {
			pushMessage(task.getValue());
			loading.unbind();
			search();
		});
		
		task.setOnFailed(evt -> {
			pushMessage(task.getException().getMessage());
			loading.unbind();
		});
		
		GlobalExecutor.get().submit(task);
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
