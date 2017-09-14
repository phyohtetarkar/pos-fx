package com.jsoft.pos.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.effects.JFXDepthManager;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class MainLayoutController implements Initializable {

	@FXML
	private JFXListView<String> list;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		list.getItems().addAll("One", "Two", "Three");
		list.setDepth(0);
		JFXDepthManager.setDepth(list, 1);
	}

}
