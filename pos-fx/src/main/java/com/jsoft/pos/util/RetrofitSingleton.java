package com.jsoft.pos.util;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitSingleton {

	private static RetrofitSingleton INSTANCE;
	private Retrofit retrofit;
	private OkHttpClient client;
	
	private RetrofitSingleton() {
		//long cacheSize = 10 * 1024 * 1024;
		//Cache cache = new Cache(new File("./cache"), cacheSize);
		
		client = new OkHttpClient.Builder()
				//.cache(cache)
				.build();
		
		retrofit = new Retrofit.Builder()
				.baseUrl(Utils.BASE_URL)
				.client(client)
				.addConverterFactory(JacksonConverterFactory.create())
				.build();
		
	}
	
	public static RetrofitSingleton getInstance() {
		if (null == INSTANCE) {
			INSTANCE = new RetrofitSingleton();
		}
		
		return INSTANCE;
	}
	
	public <T> T create(Class<T> service) {
		return retrofit.create(service);
	}
	
	public void cancelAll() {
		client.dispatcher().cancelAll();
	}
}
