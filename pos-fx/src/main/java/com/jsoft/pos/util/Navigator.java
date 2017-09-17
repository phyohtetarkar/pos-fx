package com.jsoft.pos.util;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.StackPane;

public class Navigator {

	private static StackPane primaryContainer;
	private static StackPane contentView;
	private static Node currentOwner;
	private static Label loading;
	private static Label title;

	public static void setContentView(StackPane contentView) {
		Navigator.contentView = contentView;
	}

	public static void setPrimaryContainer(StackPane primaryContainer) {
		Navigator.primaryContainer = primaryContainer;
	}

	public static void setLoadingView(Label loading) {
		Navigator.loading = loading;
	}

	public static void setTitle(Label title) {
		Navigator.title = title;
	}

	public static void setCurrentOwner(Node currentOwner) {
		Navigator.currentOwner = currentOwner;
	}

	public static void navigate(String action) {

		switch (action.toLowerCase()) {
		case "close":
			Platform.exit();
			break;
		
		case "logout":
			logout();
			break;
		default:
			handle(action);
			break;
		}
	}

	public static void showLoading(boolean visibility) {
		loading.getGraphic().setVisible(visibility);
		loading.setVisible(visibility);
	}

	public static void lowerBrightness() {
		if (null != currentOwner) {
			currentOwner.setEffect(new ColorAdjust(0, 0, -0.2, 0));
		} else {
			contentView.setEffect(new ColorAdjust(0, 0, -0.2, 0));
		}

	}

	public static void resetBrightness() {
		if (null != currentOwner) {
			currentOwner.setEffect(null);
		} else {
			contentView.setEffect(null);
		}
	}
	
	public static void login() {
		appInOut("Main");
	}
	
	public static void logout() {
		appInOut("Login");
	}
	
	private static void appInOut(String action) {
		try {
			action = action.replace(" ", "").concat("View");
			String viewName = String.format("%s.fxml", action.toUpperCase());
			
			FXMLLoader loader = new FXMLLoader(Navigator.class.getResource(String.format("/fxml/%s", viewName)));
			primaryContainer.getChildren().clear();
			primaryContainer.getChildren().add(loader.load());

		} catch (IOException e) {
			e.printStackTrace();
			primaryContainer.getChildren().clear();
		}
	}

	private static void handle(String action) {

		try {
			title.setText(action);
			action = action.replace(" ", "").concat("View");
			String viewName = String.format("%s.fxml", action.toUpperCase());

			FXMLLoader loader = new FXMLLoader(Navigator.class.getResource(String.format("/fxml/%s", viewName)));

			contentView.getChildren().clear();
			contentView.getChildren().add(loader.load());

		} catch (IOException e) {
			e.printStackTrace();
			contentView.getChildren().clear();
		}

	}
}