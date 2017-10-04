package com.jsoft.pos.service;

import java.util.List;

import com.jsoft.pos.domain.Item;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ItemService {

	@GET("item/search")
	Call<List<Item>> search(@Query("code") String code, 
			@Query("name") String name, 
			@Query("categoryId") int categoryId, 
			@Query("offset") int offset, 
			@Query("limit") int limit);
	
	@GET("item/count")
	Call<Long> count(@Query("code") String code, 
			@Query("name") String name, 
			@Query("categoryId") int categoryId);
	
	@GET("item/find/code")
	Call<Item> findByCode(@Query("code") String code);
	
	@GET("item/{id}")
	Call<Item> findById(@Path("id") int id);
	
	@POST("item")
	Call<String> save(@Body Item item);
	
	@Multipart
    @POST("item/upload")        
    Call<String> uploadImage(@Part("image") RequestBody body);
}
