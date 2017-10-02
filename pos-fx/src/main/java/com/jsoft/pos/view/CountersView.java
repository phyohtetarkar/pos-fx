package com.jsoft.pos.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;
import com.jsoft.pos.domain.Counter;
import com.jsoft.pos.util.AlertUtil;
import com.jsoft.pos.view.custom.ActionMenu;
import com.jsoft.pos.view.form.InputView;
import com.jsoft.pos.view.model.CountersViewModel;
import com.jsoft.pos.view.model.SinglePageViewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class CountersView extends SinglePageView<Counter> {
	
	private static final String CREATE_HEADING = "Create New Counter";
	private static final String EDIT_HEADING = "Edit Counter";
	private static final String INPUT_PLACEHOLDER = "Counter";

	@FXML
	private TableColumn<Counter, String> createDate;
	@FXML
	private TableColumn<Counter, String> updateDate;
	@FXML
	private JFXTextField filter;
	
	private CountersViewModel model;
	
	@Override
	protected SinglePageViewModel<Counter> model() {
		return model;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model = new CountersViewModel();
		
		tableView.setContextMenu(ActionMenu.builder()
				.onEdit(e -> {
					Counter counter = tableView.getSelectionModel().getSelectedItem();
					InputView.show(EDIT_HEADING, INPUT_PLACEHOLDER, counter, c -> {
						model.save((Counter) c);
					});
				})
				.onDelete(e -> {
					Counter counter = tableView.getSelectionModel().getSelectedItem();
					if (AlertUtil.showConfirm("Are you sure to delete?")) {
						model.delete(counter);
					}
				})
				.build());
		
		createDate.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getSecurity().getCreateDate()));
		updateDate.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getSecurity().getUpdateDate()));

		filter.textProperty().addListener((a, b, c) -> model.filter(c.toLowerCase()));
		
		super.initialize(location, resources);
	}
	
	public void add() {
		InputView.show(CREATE_HEADING, INPUT_PLACEHOLDER, new Counter(), c -> {
			model.save((Counter) c);
		});
	}

	public void clear() {
		filter.clear();
	}
	
}
