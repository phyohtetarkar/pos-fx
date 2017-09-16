package com.jsoft.pos.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.effects.JFXDepthManager;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable {

	@FXML
	private JFXListView<String> list;
	@FXML
	private VBox menuBox;
	@FXML
	private Label naviPath;
	@FXML
	private AnchorPane container;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		list.getItems().addAll("One", "Two", "Three");
		list.setDepth(0);
		list.getSelectionModel().select(0);
		JFXDepthManager.setDepth(menuBox, 1);
		
	}

}
