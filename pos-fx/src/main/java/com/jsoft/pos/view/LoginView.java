package com.jsoft.pos.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jsoft.pos.util.Navigator;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

public class LoginView implements Initializable {
	
	@FXML
    private JFXTextField loginId;
    @FXML
    private JFXPasswordField password;
    @FXML
    private StackPane primaryContainer;
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		Navigator.setPrimaryContainer(primaryContainer);
	}

    public void login() {
    		Navigator.login();
    }

}
