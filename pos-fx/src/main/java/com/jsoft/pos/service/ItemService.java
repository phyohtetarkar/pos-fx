package com.jsoft.pos.service;

import java.util.List;

import com.jsoft.pos.domain.Item;

import retrofit2.Call;

public interface ItemService {

	Call<List<Item>> search();
	
	Call<Long> count();
	
	Call<Item> findById(int id);
	
	Call<Item> findByCode(String code);
	
	Call<String> save(Item item);
}
