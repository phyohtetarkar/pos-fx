package com.jsoft.pos.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jsoft.pos.util.Navigator;

import javafx.beans.property.BooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoadingDialogView implements Initializable {
	
	@FXML
	private Label message;
	
	public static void init(String message, BooleanProperty showProperty) {
		try {
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UNDECORATED);
			
			FXMLLoader loader = new FXMLLoader(LoadingDialogView.class.getResource("LoadingDialogView.fxml"));
			
			HBox view = loader.load();
			LoadingDialogView controller = loader.getController();
			controller.message.setText(message);
			
			stage.setOnShowing(e -> Navigator.lowerBrightness());
			stage.setOnHidden(evt -> Navigator.resetBrightness());
			
			Scene scene = new Scene(view);
			stage.setScene(scene);
			
			showProperty.addListener((v, ov, nv) -> {
				if (nv) {
					stage.show();
				} else {
					stage.hide();
				}
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	public void hide() {
		message.getScene().getWindow().hide();
	}
}
