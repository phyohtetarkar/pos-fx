package com.jsoft.pos.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jsoft.pos.domain.Category;
import com.jsoft.pos.domain.Item;
import com.jsoft.pos.view.model.ItemsViewModel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableView;

public class ItemsView implements Initializable {
	
	@FXML
	private TableView<Item> tableView;
	@FXML
	private JFXComboBox<Category> categories;
	@FXML
	private JFXTextField code;
	@FXML
	private JFXTextField name;
	@FXML
	private Pagination pagination;
	@FXML
	private Label pageInfo;
	
	private ItemsViewModel model;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model = new ItemsViewModel();
		
		categories.itemsProperty().bind(model.categoriesProperty());
		
		model.categoryProperty().bind(categories.getSelectionModel().selectedItemProperty());
		model.codeProperty().bind(code.textProperty());
		model.nameProperty().bind(name.textProperty());
		
		pagination.pageCountProperty().bind(model.pageProperty());
		model.pageProperty().set(10);
		model.currentPageProperty().bind(pagination.currentPageIndexProperty());
		
		pagination.currentPageIndexProperty().addListener((a, b, c) -> model.search());
		
		model.init();
	}

	public void search() {
		pagination.setCurrentPageIndex(0);
		model.search();
	}
	
	public void clear() {
		categories.getSelectionModel().clearSelection();
		code.clear();
		name.clear();
	}
}
