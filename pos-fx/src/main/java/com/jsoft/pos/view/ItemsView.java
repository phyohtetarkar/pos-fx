package com.jsoft.pos.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jsoft.pos.domain.Category;
import com.jsoft.pos.domain.Item;
import com.jsoft.pos.view.model.ItemsViewModel;
import com.jsoft.pos.view.model.PagableViewModel;

import javafx.fxml.FXML;

public class ItemsView extends PagableView<Item> {

	@FXML
	private JFXComboBox<Category> categories;
	@FXML
	private JFXTextField code;
	@FXML
	private JFXTextField name;
	
	private ItemsViewModel model;
	
	@Override
	protected PagableViewModel<Item> model() {
		return model;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model = new ItemsViewModel();
		
		categories.itemsProperty().bind(model.categoriesProperty());

		model.categoryProperty().bind(categories.getSelectionModel().selectedItemProperty());
		model.codeProperty().bind(code.textProperty());
		model.nameProperty().bind(name.textProperty());
		
		super.initialize(location, resources);
	}
	
	public void clear() {
		categories.getSelectionModel().clearSelection();
		code.clear();
		name.clear();
	}

	
}
