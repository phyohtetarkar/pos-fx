package com.jsoft.pos.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GlobalExecutor {

	private static ExecutorService executorService;
	
	static {
		executorService = Executors.newCachedThreadPool();
	}
	
	public static ExecutorService get() {
		return executorService;
	}
	
	public static void shutdown() {
		executorService.shutdown();
	}
}
