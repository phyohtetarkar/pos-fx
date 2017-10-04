package com.jsoft.pos.view.model;

import java.io.File;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import com.jsoft.pos.domain.Category;
import com.jsoft.pos.domain.Item;
import com.jsoft.pos.domain.wrapper.ItemWrapper;
import com.jsoft.pos.repo.CategoryRepo;
import com.jsoft.pos.repo.ItemRepo;
import com.jsoft.pos.repo.retrofit.impl.CategoryRepoImpl;
import com.jsoft.pos.repo.retrofit.impl.ItemRepoImpl;
import com.jsoft.pos.util.OperationCallback;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;

public class ItemFormViewModel {
	private ListProperty<Category> categories = new SimpleListProperty<>();
	private BooleanProperty loading = new SimpleBooleanProperty();
	private DoubleProperty upload = new SimpleDoubleProperty();

	private Consumer<String> onMessage;
	private OnFinishedListener onFinishedListener;
	
	private ItemWrapper wrapper;
	private ItemRepo repo;
	private CategoryRepo catRepo;

	public ItemFormViewModel() {
		wrapper = new ItemWrapper();
		repo = new ItemRepoImpl();
		catRepo = new CategoryRepoImpl();
	}
	
	public void init() {
		loadCategories();
	}
	
	public void save() {
		Task<String> task = new Task<String>() {
			@Override
			protected String call() throws Exception {
				Item item = wrapper.build();
				return repo.save(item);
			}
		};
		
		loading.bind(task.runningProperty());
		
		task.setOnSucceeded(evt -> {
			pushMessage(task.getValue());
			loading.unbind();
			if (onFinishedListener != null) {
				onFinishedListener.finished();
			}
		});
		
		task.setOnFailed(evt -> {
			pushMessage(task.getException().getMessage());
			loading.unbind();
		});
		
		Executors.newSingleThreadExecutor().submit(task);
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
			Category category = wrapper.categoryProperty().get();
			if (category != null) {
				wrapper.categoryProperty().set(null);
				wrapper.categoryProperty().set(category);
			} else {
				wrapper.categoryProperty().set(categories.get(0));
			}
		});
		
		task.setOnFailed(evt -> {
			pushMessage(task.getException().getMessage());
		});
		
		Executors.newSingleThreadExecutor().submit(task);
	}
	
	public void upload(File image, OperationCallback callback) {
		Task<String> task = new Task<String>() {
			@Override
			protected String call() throws Exception {
				return repo.uploadImage(image, callback);
			}
		};
		
		task.setOnSucceeded(evt -> {
			pushMessage(task.getValue());
		});
		
		task.setOnFailed(evt -> {
			pushMessage(task.getException().getMessage());
		});
		
		Executors.newSingleThreadExecutor().submit(task);
	}
	
	private void pushMessage(String message) {
		if (onMessage != null) {
			onMessage.accept(message);
		}
	}
	
	public void setOnMessage(Consumer<String> onMessage) {
		this.onMessage = onMessage;
	}
	
	public void setOnSaveComplete(OnFinishedListener onFinishedListener) {
		this.onFinishedListener = onFinishedListener;
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
	
	public DoubleProperty uploadProperty() {
		return upload;
	}
	
}
