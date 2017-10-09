package com.jsoft.pos.view.model;

import java.util.Objects;
import java.util.function.Consumer;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class PagableViewModel<T> {
	
	protected int limit = 20;
	protected int count = 0;
	
	protected ListProperty<T> list = new SimpleListProperty<>();
	protected BooleanProperty loading = new SimpleBooleanProperty();
	
	protected IntegerProperty page = new SimpleIntegerProperty();
	protected IntegerProperty currentPage = new SimpleIntegerProperty();
	protected StringProperty pageInfo = new SimpleStringProperty();
	
	protected Consumer<String> onMessage;
	
	public abstract void init();
	public abstract void search();
	public abstract void searchPage();
	
	protected void pushMessage(String message) {
		if (Objects.nonNull(onMessage)) {
			onMessage.accept(message);
		}
	}
	
	public void setOnMessage(Consumer<String> onMessage) {
		this.onMessage = onMessage;
	}
	
	public final ListProperty<T> listProperty() {
		return list;
	}
	
	public final BooleanProperty loadingProperty() {
		return loading;
	}
	
	public IntegerProperty pageProperty() {
		return page;
	}

	public IntegerProperty currentPageProperty() {
		return currentPage;
	}
	
	public StringProperty pageInfoProperty() {
		return pageInfo;
	}

}
