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
	
	protected static int LIMIT = 25;
	
	protected ListProperty<T> values = new SimpleListProperty<>();
	protected BooleanProperty loading = new SimpleBooleanProperty();
	
	protected IntegerProperty page = new SimpleIntegerProperty();
	protected IntegerProperty currentPage = new SimpleIntegerProperty();
	protected StringProperty pageInfo = new SimpleStringProperty();
	
	public abstract void loadValues();
	
	protected Callback<Long> countCallBack() {
		return new Callback<Long>() {

			@Override
			public void onResponse(Call<Long> call, Response<Long> resp) {
				if (resp.isSuccessful()) {
					Platform.runLater(() -> page.set(resp.body().intValue() / LIMIT));
					loadValues();
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
	
	protected Callback<List<T>> valuesCallBack() {
		return new Callback<List<T>>() {

			@Override
			public void onResponse(Call<List<T>> call, Response<List<T>> resp) {
				if (resp.isSuccessful()) {
					loading.set(false);
					values.set(FXCollections.observableArrayList(resp.body()));
					
					int offset = currentPage.get() * LIMIT;
					int range = offset + values.size();
					Platform.runLater(() -> {
						pageInfo.set(String.format("Showing %d to %d of %d", offset, 
								values.size() > 0 ? range : 0, page.get()));
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
	
	public final ListProperty<T> valuesProperty() {
		return values;
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
