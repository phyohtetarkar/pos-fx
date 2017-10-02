package com.jsoft.pos.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;
import com.jsoft.pos.domain.Category;
import com.jsoft.pos.util.AlertUtil;
import com.jsoft.pos.util.Navigator;
import com.jsoft.pos.view.custom.ActionMenu;
import com.jsoft.pos.view.model.CategoriesViewModel;
import com.jsoft.pos.view.model.SinglePageViewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class CategoriesView extends SinglePageView<Category> {
	
	private static final String CREATE_HEADING = "Create New Category";
	private static final String EDIT_HEADING = "Edit Category";
	private static final String INPUT_PLACEHOLDER = "Category Name";

	@FXML
	private TableColumn<Category, String> createDate;
	@FXML
	private TableColumn<Category, String> updateDate;
	@FXML
	private JFXTextField filter;

	private CategoriesViewModel model;

	@Override
	protected SinglePageViewModel<Category> model() {
		return model;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model = new CategoriesViewModel();

		tableView.setContextMenu(ActionMenu.builder()
				.onEdit(e -> {
					Category category = tableView.getSelectionModel().getSelectedItem();
					InputView.show(EDIT_HEADING, INPUT_PLACEHOLDER, category, c -> {
						model.save((Category) c);
					});
				})
				.onDelete(e -> {
					Category c = tableView.getSelectionModel().getSelectedItem();
					if (AlertUtil.showConfirm("Are you sure to delete?")) {
						model.delete(c);
					}
				})
				.build());
		
		createDate.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getSecurity().getCreateDate()));
		updateDate.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getSecurity().getUpdateDate()));

		filter.textProperty().addListener((a, b, c) -> model.filter(c.toLowerCase()));
		
		Navigator.setRefreshAction(e -> model.load());

		super.initialize(location, resources);
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
