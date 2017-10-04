package com.jsoft.pos.view.form;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import com.jfoenix.controls.JFXTextField;
import com.jsoft.pos.domain.Nameable;
import com.jsoft.pos.util.Navigator;
import com.jsoft.pos.util.Utils;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class InputView implements Initializable {
	
	@FXML
	private Label heading;
	@FXML
	private JFXTextField input;
	
	private Nameable entity;
	private Consumer<Nameable> consumer;
	
	public static void show(String heading, String placeholder, Nameable entity, Consumer<Nameable> consumer) {
		try {
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UNDECORATED);
			
			FXMLLoader loader = new FXMLLoader(InputView.class.getResource("InputView.fxml"));
			
			VBox view = loader.load();
			InputView context = loader.getController();
			
			context.consumer = consumer;
			context.entity = entity;
			context.heading.setText(heading);
			context.input.setPromptText(placeholder);
			
			if (entity.getName() != null) {
				Platform.runLater(() -> context.input.setText(entity.getName())); 
			}
			
			stage.setOnShowing(e -> Navigator.lowerBrightness());
			stage.setOnHidden(evt -> Navigator.resetBrightness());
			
			Scene scene = new Scene(view);
			stage.setScene(scene);
			stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		input.getValidators().add(Utils.requiredValidator());
	}

	public void save() {
		if (input.validate()) {
			close();
			entity.setName(input.getText());
			consumer.accept(entity);
		}
	}
	
	public void close() {
		heading.getScene().getWindow().hide();
	}
}
