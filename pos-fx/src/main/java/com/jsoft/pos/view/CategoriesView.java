package com.jsoft.pos.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import com.jsoft.pos.domain.Category;
import com.jsoft.pos.util.Navigator;
import com.jsoft.pos.view.custom.ActionMenu;
import com.jsoft.pos.view.model.CategoriesViewModel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class CategoriesView implements Initializable {
	
	private static final String CREATE_HEADING = "Create New Category";
	private static final String EDIT_HEADING = "Edit Category";
	private static final String INPUT_PLACEHOLDER = "Category Name";

	@FXML
	private TableView<Category> tableView;
	@FXML
	private JFXTextField filter;
	@FXML
	private JFXSpinner spinner;

	private CategoriesViewModel model;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model = new CategoriesViewModel();

		tableView.itemsProperty().bind(model.categoriesProperty());
		tableView.setPlaceholder(new Label(""));
		tableView.setContextMenu(ActionMenu.builder()
				.onEdit(e -> {
					Category category = tableView.getSelectionModel().getSelectedItem();
					InputView.show(EDIT_HEADING, INPUT_PLACEHOLDER, category, c -> {
						model.save((Category) c);
					});
				})
				.onDelete(e -> {
					Category c = tableView.getSelectionModel().getSelectedItem();
					model.delete(c);
				})
				.build());

		filter.textProperty().addListener((a, b, c) -> model.filter(c.toLowerCase()));

		spinner.visibleProperty().bind(model.loadingProperty());
		
		Navigator.setRefreshAction(e -> model.load());

		model.load();
	}

	public void add() {
		InputView.show(CREATE_HEADING, INPUT_PLACEHOLDER, new Category(), c -> {
			model.save((Category) c);
		});
	}

	public void clear() {
		filter.clear();
	}

}
