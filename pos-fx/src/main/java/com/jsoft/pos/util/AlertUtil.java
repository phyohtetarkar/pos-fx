package com.jsoft.pos.util;

import java.util.Optional;

import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXSnackbar.SnackbarEvent;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.stage.StageStyle;

public class AlertUtil {

	private static JFXSnackbar snackBar;

	public static void setSnackBar(JFXSnackbar snackBar) {
		AlertUtil.snackBar = snackBar;
	}

	public static void queueToast(String message) {
		snackBar.enqueue(new SnackbarEvent(message));
	}
	
	public static void showInfo(String message) {
		Alert alert = buildAlert(AlertType.ERROR, message);
		alert.show();
	}
	
	public static void showWarning(String message) {
		Alert alert = buildAlert(AlertType.ERROR, message);
		alert.show();
	}
	
	public static void showError(String message) {
		Alert alert = buildAlert(AlertType.ERROR, message);
		alert.show();
	}
	
	public static boolean showConfirm(String message) {
		ButtonType ok = new ButtonType("OK", ButtonData.OK_DONE);
		ButtonType cancel = new ButtonType("CANCEL", ButtonData.CANCEL_CLOSE);
		Alert alert = buildAlert(AlertType.CONFIRMATION, message, ok, cancel);
		Optional<ButtonType> type = alert.showAndWait();
		
		return type.get() == ok;
	}

	private static Alert buildAlert(AlertType alertType, String message) {
		return buildAlert(alertType, message, null, null);
	}
	
	private static Alert buildAlert(AlertType alertType, String message, 
			ButtonType positive, ButtonType negative) {

		Alert alert = new Alert(alertType, message, positive, negative);
		alert.setHeaderText(null);
		alert.initStyle(StageStyle.UNDECORATED);
		alert.getDialogPane().getStylesheets().add(
				AlertUtil.class.getResource("dialog.css").toExternalForm());
		alert.setOnShowing(evt -> Navigator.lowerBrightness());
		alert.setOnHidden(evt -> Navigator.resetBrightness());

		return alert;
	}
}
