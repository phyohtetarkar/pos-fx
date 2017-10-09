package com.jsoft.pos.repo.retrofit;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.jsoft.pos.domain.Item;
import com.jsoft.pos.repo.ItemRepo;
import com.jsoft.pos.service.ItemService;
import com.jsoft.pos.util.OperationCallback;
import com.jsoft.pos.util.ProgressRequestBody;
import com.jsoft.pos.util.ApplicationException;
import com.jsoft.pos.util.RetrofitSingleton;
import com.jsoft.pos.util.ServerStatus;

import okhttp3.RequestBody;
import retrofit2.Response;

public class ItemRepoImpl implements ItemRepo {
	
	private ItemService service;
	
	public ItemRepoImpl() {
		service = RetrofitSingleton.getInstance().create(ItemService.class);
	}

	@Override
	public List<Item> search(String code, String name, int categoryId, int offset, int limit) {
		try {
			Response<List<Item>> resp = service.search(code, name, categoryId, offset, limit).execute();
			if (!resp.isSuccessful()) {
				throw new ApplicationException(resp.errorBody().string());
			} 
			
			return resp.body();
		} catch (IOException e) {
			e.printStackTrace();
			throw new ApplicationException(ServerStatus.CONNECTION_ERROR);
		}
	}

	@Override
	public Long count(String code, String name, int categoryId) {
		try {
			Response<Long> resp = service.count(code, name, categoryId).execute();
			if (!resp.isSuccessful()) {
				throw new ApplicationException(resp.errorBody().string().replace("\"", ""));
			} 
			
			return resp.body();
		} catch (IOException e) {
			e.printStackTrace();
			throw new ApplicationException(ServerStatus.CONNECTION_ERROR);
		}
	}

	@Override
	public Item findById(int id) {
		try {
			Response<Item> resp = service.findById(id).execute();
			if (!resp.isSuccessful()) {
				throw new ApplicationException(resp.errorBody().string().replace("\"", ""));
			} 
			
			return resp.body();
		} catch (IOException e) {
			e.printStackTrace();
			throw new ApplicationException(ServerStatus.CONNECTION_ERROR);
		}
	}

	@Override
	public String save(Item item) {
		try {
			Response<String> resp = service.save(item).execute();
			if (!resp.isSuccessful()) {
				throw new ApplicationException(resp.errorBody().string().replace("\"", ""));
			} 
			
			return resp.body();
		} catch (IOException e) {
			e.printStackTrace();
			throw new ApplicationException(ServerStatus.CONNECTION_ERROR);
		}
	}

	@Override
	public String uploadImage(File file, OperationCallback callback) {
		RequestBody body = new ProgressRequestBody(file, null, callback);
		try {
			Response<String> resp = service.uploadImage(body).execute();
			if (!resp.isSuccessful()) {
				throw new ApplicationException(resp.errorBody().string().replace("\"", ""));
			} 
			
			return resp.body();
		} catch (IOException e) {
			e.printStackTrace();
			if (callback != null) {
				callback.onError();
			}
			throw new ApplicationException(ServerStatus.CONNECTION_ERROR);
		}
	}

}
