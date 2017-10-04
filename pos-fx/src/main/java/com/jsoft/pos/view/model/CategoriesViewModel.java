package com.jsoft.pos.view.model;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import com.jsoft.pos.domain.Category;
import com.jsoft.pos.repo.CategoryRepo;
import com.jsoft.pos.repo.retrofit.impl.CategoryRepoImpl;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;

public class CategoriesViewModel {
	
	private List<Category> copyList;

	private ListProperty<Category> list = new SimpleListProperty<>();
	private final BooleanProperty loading = new SimpleBooleanProperty();
	
	private Consumer<String> onMessage;

	private CategoryRepo repo;
	
	public CategoriesViewModel() {
		repo = new CategoryRepoImpl();
	}

	public void load() {
		Task<List<Category>> task = new Task<List<Category>>() {
			@Override
			protected List<Category> call() throws Exception {
				return repo.findAll();
			}
		};
		
		loading.bind(task.runningProperty());
		
		task.setOnSucceeded(evt -> {
			copyList = task.getValue();
			list.clear();
			list.set(FXCollections.observableArrayList(copyList));
			loading.unbind();
		});
		
		task.setOnFailed(evt -> {
			pushMessage(task.getException().getMessage());
			loading.unbind();
		});
		
		Executors.newSingleThreadExecutor().submit(task);
	}
	
	public void delete(Category category) {
		category.setDeleted(true);
		save(category);
	}
	
	public void save(Category category) {
		Task<String> task = new Task<String>() {
			@Override
			protected String call() throws Exception {
				return repo.save(category);
			}
		};
		
		loading.bind(task.runningProperty());
		
		task.setOnSucceeded(evt -> {
			onMessage.accept(task.getValue());
			loading.unbind();
			load();
		});
		
		task.setOnFailed(evt -> {
			pushMessage(task.getException().getMessage());
			loading.unbind();
		});
		
		Executors.newSingleThreadExecutor().submit(task);
	}
	
	public void filter(String text) {
		if (copyList != null) {
			list.set(FXCollections.observableArrayList(copyList.stream()
					.filter(c -> c.getName().toLowerCase().startsWith(text))
					.collect(Collectors.toList())));
		}
	}
	
	private void pushMessage(String message) {
		if (onMessage != null) {
			onMessage.accept(message);
		}
	}
	
	public void setOnMessage(Consumer<String> onMessage) {
		this.onMessage = onMessage;
	}
	
	public final ListProperty<Category> listProperty() {
		return list;
	}
	
	public final BooleanProperty loadingProperty() {
		return loading;
	}
}
