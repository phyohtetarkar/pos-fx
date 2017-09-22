package com.jsoft.pos.util;

import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXSnackbar.SnackbarEvent;

public class AlertUtil {

	private static JFXSnackbar snackBar;
	
	public static void setSnackBar(JFXSnackbar snackBar) {
		AlertUtil.snackBar = snackBar;
	}
	
	public static void queueToast(String message) {
		snackBar.enqueue(new SnackbarEvent(message));
	}
}
