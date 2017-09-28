package com.jsoft.pos.view.model;

import java.io.IOException;
import java.util.List;

import com.jsoft.pos.util.AlertUtil;

import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class PagableViewModel<T> {
	
	protected int limit = 25;
	protected int count = 0;
	
	protected ListProperty<T> list = new SimpleListProperty<>();
	protected BooleanProperty loading = new SimpleBooleanProperty();
	
	protected IntegerProperty page = new SimpleIntegerProperty();
	protected IntegerProperty currentPage = new SimpleIntegerProperty();
	protected StringProperty pageInfo = new SimpleStringProperty();
	
	public abstract void init();
	public abstract void queryList();
	public abstract void search();
	
	protected Callback<Long> countCallBack() {
		return new Callback<Long>() {

			@Override
			public void onResponse(Call<Long> call, Response<Long> resp) {
				if (resp.isSuccessful()) {
					count = resp.body().intValue();
					Platform.runLater(() -> page.set(count / limit));
					queryList();
				} else {
					loading.set(false);
				}
			}

			@Override
			public void onFailure(Call<Long> call, Throwable t) {
				t.printStackTrace();
				loading.set(false);
				AlertUtil.queueToast(t.getMessage());

			}
		};
	}
	
	protected Callback<List<T>> listCallBack() {
		return new Callback<List<T>>() {

			@Override
			public void onResponse(Call<List<T>> call, Response<List<T>> resp) {
				if (resp.isSuccessful()) {
					loading.set(false);
					list.set(FXCollections.observableArrayList(resp.body()));
					
					int offset = currentPage.get() * limit;
					int range = offset + list.size();
					Platform.runLater(() -> {
						pageInfo.set(String.format("Showing %d to %d of %d", offset, 
								list.size() > 0 ? range : 0, count));
					}); 
					
				} else {
					loading.set(false);
					try {
						System.out.println(resp.errorBody().string());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

			@Override
			public void onFailure(Call<List<T>> call, Throwable t) {
				t.printStackTrace();
				loading.set(false);
				AlertUtil.queueToast(t.getMessage());
			}

		};
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
