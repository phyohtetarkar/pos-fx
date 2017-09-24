package com.jsoft.pos.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import com.jsoft.pos.domain.Category;
import com.jsoft.pos.util.Navigator;
import com.jsoft.pos.view.custom.ActionMenu;
import com.jsoft.pos.vm.CategoriesViewModel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class CategoriesView implements Initializable {
	
	private static final String DIALOG_HEADING = "Create new category";
	private static final String INPUT_PLACEHOLDER = "Enter category name";

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
					Category c = tableView.getSelectionModel().getSelectedItem();
					InputView.show(DIALOG_HEADING, INPUT_PLACEHOLDER, c.getName(), s -> {
						if (!s.trim().isEmpty()) {
							model.save(s, c.getId());
						}
					});
				})
				.onDelete(e -> {
					Category c = tableView.getSelectionModel().getSelectedItem();
					model.delete(c);
				})
				.build());

		filter.textProperty().addListener((a, b, c) -> filter(c));

		spinner.visibleProperty().bind(model.loadingProperty());
		Navigator.setRefreshAction(e -> model.load());

		model.load();
	}

	public void filter(String text) {
		model.filter(text.toLowerCase());
	}

	public void add() {
		InputView.show(DIALOG_HEADING, INPUT_PLACEHOLDER, s -> {
			if (!s.trim().isEmpty()) {
				model.save(s, 0);
			}
		});
	}

	public void clear() {
		filter.clear();
	}

}
