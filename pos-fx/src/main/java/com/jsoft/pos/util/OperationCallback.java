package com.jsoft.pos.util;

public interface OperationCallback {
	
	void onProgressUpdate(double value);
	
	void onFinished();
	
	void onError();
	
}
