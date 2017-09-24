package com.jsoft.pos.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRippler;
import com.jfoenix.controls.JFXSnackbar;
import com.jsoft.pos.util.AlertUtil;
import com.jsoft.pos.util.Navigator;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
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
	@FXML
	private AnchorPane root;
	@FXML
	private JFXSnackbar snackBar;
	@FXML
	private JFXRippler refresh;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		list.getItems().addAll("Home", "Pos", "Items", "Categories", "Logout");
		list.setDepth(0);
		list.getSelectionModel().select(1);
		
		Navigator.setContentView(container);
		Navigator.setTitle(naviPath);
		Navigator.setRefresh(refresh);
		
		snackBar.registerSnackbarContainer(root);
		AlertUtil.setSnackBar(snackBar);
		
		Navigator.currentViewProperty().bind(list.getSelectionModel().selectedItemProperty());
		
	}

}
