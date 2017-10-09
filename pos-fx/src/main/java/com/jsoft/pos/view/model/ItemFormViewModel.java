package com.jsoft.pos.view.model;

import java.io.File;
import java.util.List;
import java.util.function.Consumer;

import com.jsoft.pos.domain.Category;
import com.jsoft.pos.domain.Item;
import com.jsoft.pos.domain.wrapper.ItemWrapper;
import com.jsoft.pos.repo.CategoryRepo;
import com.jsoft.pos.repo.ItemRepo;
import com.jsoft.pos.util.GlobalExecutor;
import com.jsoft.pos.util.OperationCallback;
import com.jsoft.pos.util.RepositoryFactory;
import com.jsoft.pos.util.RepositoryFactory.Provider;

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
		repo = RepositoryFactory.create(ItemRepo.class, Provider.RETROFIT);
		catRepo = RepositoryFactory.create(CategoryRepo.class, Provider.RETROFIT);
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
		
		GlobalExecutor.get().submit(task);
	}
	
	public void upload(File image) {
		upload.set(0);
		Task<String> task = new Task<String>() {
			@Override
			protected String call() throws Exception {
				return repo.uploadImage(image, new OperationCallback() {
					
					@Override
					public void onProgressUpdate(double value) {
						updateProgress(value, 1);
					}
					
					@Override
					public void onFinished() {
						updateProgress(1, 1);
					}
					
					@Override
					public void onError() {
						updateProgress(0, 1);
					}
				});
			}
		};
		
		upload.bind(task.progressProperty());
		
		task.setOnSucceeded(evt -> {
			pushMessage(task.getValue());
			upload.unbind();
		});
		
		task.setOnFailed(evt -> {
			pushMessage(task.getException().getMessage());
			upload.unbind();
		});
		
		GlobalExecutor.get().submit(task);
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
