package com.jsoft.pos.util;

import java.io.IOException;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class Navigator {

	private static StackPane primaryContainer;
	private static StackPane contentView;
	private static Node currentOwner;
	private static Label loading;
	private static Label title;
	private static ObjectProperty<String> currentView = new SimpleObjectProperty<>(); 
	
	static {
		currentView.addListener((a, b, c) -> navigate(c));
	}

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
	
	public static ObjectProperty<String> currentViewProperty() {
		return currentView;
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
			handle(action, contentView);
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
		handle("Main", primaryContainer);
	}
	
	public static void logout() {
		handle("Login", primaryContainer);
	}

	private static void handle(String action, Pane view) {

		try {
			if (null != title) {
				title.setText(action);
			}
			
			action = action.replace(" ", "").concat("View");
			String viewName = String.format("%s.fxml", action.toUpperCase());

			FXMLLoader loader = new FXMLLoader(Navigator.class.getResource(String.format("/fxml/%s", viewName)));

			view.getChildren().clear();
			view.getChildren().add(loader.load());

		} catch (IOException e) {
			e.printStackTrace();
			view.getChildren().clear();
		}

	}
}
