package com.jsoft.pos.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXSpinner;
import com.jsoft.pos.domain.Nameable;
import com.jsoft.pos.view.model.SinglePageViewModel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public abstract class SinglePageView<T extends Nameable> implements Initializable {
	
	@FXML
	protected TableView<T> tableView;
	@FXML
	protected JFXSpinner spinner;
	
	protected abstract SinglePageViewModel<T> model();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tableView.itemsProperty().bind(model().listProperty());
		tableView.setPlaceholder(new Label(""));
		
		spinner.visibleProperty().bind(model().loadingProperty());
		
		model().load();
	}

}
