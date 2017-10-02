package com.jsoft.pos.util;

import java.io.IOException;

import com.jfoenix.controls.JFXRippler;
import com.jsoft.pos.view.MainView;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class Navigator {

	private static StackPane primaryContainer;
	private static StackPane contentView;
	private static Label title;
	private static JFXRippler refresh;
	private static ObjectProperty<String> currentView = new SimpleObjectProperty<>();
	
	static {
		currentView.addListener((a, b, c) -> {
			navigate(c);
			setNavTitle(c);
		});
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
	
	public static<T> T navigateAndWait(String action) {
		return handle(action, contentView);
	}

	public static void lowerBrightness() {
		primaryContainer.setEffect(new ColorAdjust(0, 0, -0.2, 0));
	}

	public static void resetBrightness() {
		primaryContainer.setEffect(null);
	}
	
	public static void login() {
		handle("Main", primaryContainer);
	}
	
	public static void logout() {
		handle("Login", primaryContainer);
	}
	
	public static void setNavTitle(String text) {
		title.setText(text);
	}
	
	public static void setRefreshAction(EventHandler<MouseEvent> evt) {
		if (null != refresh) {
			refresh.setOnMouseClicked(evt);
		}
	}

	private static<T> T handle(String action, Pane view) {

		try {
			
			if (null != refresh) {
				refresh.setOnMouseClicked(null);
			}
			
			action = action.replace(" ", "").concat("View");
			String viewName = String.format("%s.fxml", action);
			
			FXMLLoader loader = new FXMLLoader(MainView.class.getResource(viewName));

			view.getChildren().clear();
			Node node = loader.load();
			//play(node);
			view.getChildren().add(node);
			
			return loader.getController();

		} catch (IOException e) {
			e.printStackTrace();
			view.getChildren().clear();
		}

		return null;
	}
	
	@SuppressWarnings("unused")
	private static void play(Node node) {
		TranslateTransition trans = new TranslateTransition(Duration.millis(500), node);
		trans.setFromX(-contentView.getWidth());
		trans.setToX(contentView.getLayoutBounds().getMinX());
		
		trans.play();
	}
	
	public static void setContentView(StackPane contentView) {
		Navigator.contentView = contentView;
	}
	
	public static void setPrimaryContainer(StackPane primaryContainer) {
		Navigator.primaryContainer = primaryContainer;
	}

	public static void setTitle(Label title) {
		Navigator.title = title;
	}
	
	public static ObjectProperty<String> currentViewProperty() {
		return currentView;
	}
	
	public static void setRefresh(JFXRippler refresh) {
		Navigator.refresh = refresh;
	}
}
