package com.jsoft.pos;

import java.io.IOException;

import com.jfoenix.controls.JFXDecorator;
import com.jsoft.pos.controller.MainLayoutController;
import com.jsoft.pos.css.ApplicationCss;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ApplicationMain extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		try {
			Parent root = FXMLLoader.load(MainLayoutController.class.getResource("MainLayout.fxml"));
			String css = ApplicationCss.class.getResource("jfx-common.css").toExternalForm();
			
			JFXDecorator decor = new JFXDecorator(stage, root, false, true, true);
			decor.setCustomMaximize(true);
			Scene scene = new Scene(decor);
			scene.getStylesheets().add(css);
			stage.setScene(scene);
			stage.setTitle("Restaurant POS");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
