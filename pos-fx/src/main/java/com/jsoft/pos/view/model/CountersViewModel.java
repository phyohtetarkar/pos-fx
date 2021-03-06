package com.jsoft.pos.view.model;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import com.jsoft.pos.domain.Counter;
import com.jsoft.pos.repo.CounterRepo;
import com.jsoft.pos.util.GlobalExecutor;
import com.jsoft.pos.util.RepositoryFactory;
import com.jsoft.pos.util.RepositoryFactory.Provider;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;

public class CountersViewModel {
	
	private List<Counter> copyList;

	private ListProperty<Counter> list = new SimpleListProperty<>();
	private BooleanProperty loading = new SimpleBooleanProperty();
	
	private Consumer<String> onMessage;

	private CounterRepo repo;
	
	public CountersViewModel() {
		repo = RepositoryFactory.create(CounterRepo.class, Provider.RETROFIT);
	}

	public void load() {
		Task<List<Counter>> task = new Task<List<Counter>>() {
			@Override
			protected List<Counter> call() throws Exception {
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
		
		GlobalExecutor.get().submit(task);
	}
	
	public void delete(Counter counter) {
		counter.setDeleted(true);
		save(counter);
	}
	
	public void save(Counter counter) {
		Task<String> task = new Task<String>() {
			@Override
			protected String call() throws Exception {
				return repo.save(counter);
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
		
		GlobalExecutor.get().submit(task);
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
	
	public final ListProperty<Counter> listProperty() {
		return list;
	}
	
	public final BooleanProperty loadingProperty() {
		return loading;
	}
	
}
