package com.jsoft.pos;

import java.io.IOException;

import com.jfoenix.controls.JFXDecorator;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PosMain extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/LoginView.fxml"));
			//Parent root = FXMLLoader.load(MainViewController.class.getResource("MainView.fxml"));
			
			JFXDecorator decor = new JFXDecorator(stage, root, false, true, true);
			decor.setCustomMaximize(true);
			Scene scene = new Scene(decor);
			
			final ObservableList<String> stylesheets = scene.getStylesheets();
			stylesheets.addAll(getClass().getResource("/css/jfoenix-fonts.css").toExternalForm(),
					getClass().getResource("/css/color.css").toExternalForm(),
					getClass().getResource("/css/jfx-common.css").toExternalForm());
			
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
