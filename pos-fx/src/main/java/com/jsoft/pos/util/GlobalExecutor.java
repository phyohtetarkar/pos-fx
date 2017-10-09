package com.jsoft.pos.util;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GlobalExecutor {

	private static ExecutorService executorService;
	
	public static ExecutorService get() {
		
		if (Objects.isNull(executorService)) {
			executorService = Executors.newSingleThreadExecutor();
			System.out.println("null executor");
		}
		
		return executorService;
	}
}
