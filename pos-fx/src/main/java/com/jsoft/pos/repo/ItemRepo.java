package com.jsoft.pos.repo;

import java.io.File;
import java.util.List;

import com.jsoft.pos.domain.Item;
import com.jsoft.pos.util.OperationCallback;

public interface ItemRepo {

	List<Item> search(String code, String name, int categoryId, int offset, int limit);
	
	Long count(String code, String name, int categoryId);
	
	Item findById(int id);
	
	String save(Item item);
	
	String uploadImage(File file, OperationCallback callback);
	
}
