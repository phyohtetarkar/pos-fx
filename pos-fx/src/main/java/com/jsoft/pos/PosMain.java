package com.jsoft.pos;

import java.io.IOException;

import com.jfoenix.controls.JFXDecorator;
import com.jsoft.pos.view.LoginView;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PosMain extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		try {
			Parent root = FXMLLoader.load(LoginView.class.getResource("LoginView.fxml"));
			
			JFXDecorator decor = new JFXDecorator(stage, root, false, true, true);
			decor.setCustomMaximize(true);
			Scene scene = new Scene(decor);
			
			final ObservableList<String> stylesheets = scene.getStylesheets();
			stylesheets.addAll(getClass().getResource("styles/color.css").toExternalForm(),
					getClass().getResource("styles/jfx-common.css").toExternalForm());
			
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void stop() throws Exception {
		super.stop();
		System.exit(0);
	}
}
