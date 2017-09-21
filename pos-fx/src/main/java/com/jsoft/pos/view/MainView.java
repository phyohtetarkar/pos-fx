package com.jsoft.pos.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.effects.JFXDepthManager;
import com.jsoft.pos.util.Navigator;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MainView implements Initializable {

	@FXML
	private JFXListView<String> list;
	@FXML
	private VBox menuBox;
	@FXML
	private Label naviPath;
	@FXML
	private StackPane container;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		list.getItems().addAll("Home", "Pos", "Items", "Logout");
		list.setDepth(0);
		list.getSelectionModel().select(1);
		JFXDepthManager.setDepth(menuBox, 1);
		
		Navigator.setContentView(container);
		Navigator.setTitle(naviPath);
		
		Navigator.currentViewProperty().bind(list.getSelectionModel().selectedItemProperty());
		
	}

}
