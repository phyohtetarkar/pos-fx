package com.jsoft.pos.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXSpinner;
import com.jsoft.pos.view.model.PagableViewModel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableView;

public abstract class PagableView<T> implements Initializable {
	
	@FXML
	protected TableView<T> tableView;
	@FXML
	protected Pagination pagination;
	@FXML
	protected Label pageInfo;
	@FXML
	protected JFXSpinner spinner;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		spinner.visibleProperty().bind(model().loadingProperty());
		pageInfo.textProperty().bind(model().pageInfoProperty());
		
		tableView.itemsProperty().bind(model().listProperty());
		tableView.setPlaceholder(new Label(""));
		
		pagination.pageCountProperty().bind(model().pageProperty());
		
		model().currentPageProperty().bind(pagination.currentPageIndexProperty());
		pagination.currentPageIndexProperty().addListener((a, b, c) -> model().queryList());

		model().init();
	}

	protected abstract PagableViewModel<T> model();
	
	public void search() {
		pagination.setCurrentPageIndex(0);
		model().search();
	}
}
