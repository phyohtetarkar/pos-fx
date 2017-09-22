package com.jsoft.pos.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;
import com.jsoft.pos.domain.Category;
import com.jsoft.pos.vm.CategoriesViewModel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

public class CategoriesView implements Initializable {
	
	@FXML
	private TableView<Category> tableView;
	@FXML
	private JFXTextField filter;
	
	private CategoriesViewModel model;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model = new CategoriesViewModel();
		
		tableView.itemsProperty().bind(model.categoriesProperty());
		filter.textProperty().addListener((a, b, c) -> filter(c));
		
		model.load();
	}

	public void filter(String text) {
		model.filter(text.toLowerCase());
	}
	
	public void add() {
		InputView.show(s -> {
			model.save(s);
		});
	}
	
	public void clear() {
		filter.clear();
	}
}
