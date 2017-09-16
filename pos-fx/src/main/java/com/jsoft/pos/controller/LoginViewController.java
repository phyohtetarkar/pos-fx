package com.jsoft.pos.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class LoginViewController implements Initializable {
	
	@FXML
    private JFXTextField loginId;

    @FXML
    private JFXPasswordField password;
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

    public void login() {
    	
    }

}
