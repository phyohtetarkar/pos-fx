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
	
	public static void show(Consumer<String> consumer) {
		try {
			Navigator.lowerBrightness();
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UNDECORATED);
			
			FXMLLoader loader = new FXMLLoader(InputView.class.getResource("InputView.fxml"));
			
			VBox view = loader.load();
			InputView context = loader.getController();
		
			stage.setOnHidden(evt -> {
				Navigator.resetBrightness();
				consumer.accept(context.input.getText());
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
		
		if (!input.getText().isEmpty()) {
			close();
		}
	}
	
	public void close() {
		heading.getScene().getWindow().hide();
	}
}
