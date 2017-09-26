package com.jsoft.pos.view.model;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.jsoft.pos.domain.Nameable;
import com.jsoft.pos.util.AlertUtil;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class NameableViewModel<T extends Nameable> {

	protected List<T> list;

	protected ListProperty<T> values = new SimpleListProperty<>();
	protected BooleanProperty loading = new SimpleBooleanProperty();
	
	public abstract void load();
	
	protected Callback<List<T>> valuesCallBack() {
		return new Callback<List<T>>() {
			
			@Override
			public void onResponse(Call<List<T>> call, Response<List<T>> resp) {
				loading.set(false);
				if (resp.isSuccessful()) {
					list = resp.body();
					values.set(FXCollections.observableArrayList(list));
				} else {
					System.out.println(resp.code());
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
	
	protected Callback<String> saveCallBack() {
		return new Callback<String>() {

			@Override
			public void onResponse(Call<String> call, Response<String> resp) {
				if (resp.isSuccessful()) {
					AlertUtil.queueToast(resp.body());
					load();
				} else {
					try {
						System.out.println(resp.errorBody().string());
					} catch (IOException e) {
						e.printStackTrace();
					}
				} 
			}
			
			@Override
			public void onFailure(Call<String> call, Throwable t) {
				t.printStackTrace();
				AlertUtil.queueToast(t.getMessage());
			}

		};
	}
	
	public void filter(String text) {
		if (null != list) {
			values.set(FXCollections.observableArrayList(list.stream()
					.filter(c -> c.getName().toLowerCase().startsWith(text))
					.collect(Collectors.toList())));
		}
	}
	
	public final ListProperty<T> valuesProperty() {
		return values;
	}
	
	public final BooleanProperty loadingProperty() {
		return loading;
	}

}
