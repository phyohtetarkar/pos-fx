package com.jsoft.pos.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import com.jsoft.pos.util.Navigator;

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
	
	private RequiredFieldValidator validator;
	private Consumer<String> consumer;
	
	public static void show(String heading, String placeholder, Consumer<String> consumer) {
		show(heading, placeholder, null, consumer);
	}
	
	public static void show(String heading, String placeholder, String text, Consumer<String> consumer) {
		try {
			Navigator.lowerBrightness();
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UNDECORATED);
			
			FXMLLoader loader = new FXMLLoader(InputView.class.getResource("InputView.fxml"));
			
			VBox view = loader.load();
			InputView context = loader.getController();
			
			context.consumer = consumer;
			context.heading.setText(heading);
			context.input.setPromptText(placeholder);
			
			if (null != text) {
				context.input.setText(text);
			}
		
			stage.setOnHidden(evt -> {
				Navigator.resetBrightness();
			});
			
			Scene scene = new Scene(view);
			stage.setScene(scene);
			stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		validator = new RequiredFieldValidator();
		validator.setMessage("Input required!");
		
		input.getValidators().add(validator);
	}

	public void save() {
		input.validate();
		
		if (!input.getText().trim().isEmpty()) {
			close();
			consumer.accept(input.getText());
		}
	}
	
	public void close() {
		heading.getScene().getWindow().hide();
	}
}
