package com.jsoft.pos.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import com.jsoft.pos.domain.Counter;
import com.jsoft.pos.util.AlertUtil;
import com.jsoft.pos.view.custom.ActionMenu;
import com.jsoft.pos.view.form.InputView;
import com.jsoft.pos.view.model.CountersViewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CountersView implements Initializable {
	
	private static final String CREATE_HEADING = "Create New Counter";
	private static final String EDIT_HEADING = "Edit Counter";
	private static final String INPUT_PLACEHOLDER = "Counter";

	@FXML
	protected TableView<Counter> tableView;
	@FXML
	protected JFXSpinner spinner;
	@FXML
	private TableColumn<Counter, String> createDate;
	@FXML
	private TableColumn<Counter, String> updateDate;
	@FXML
	private JFXTextField filter;
	
	private CountersViewModel model;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model = new CountersViewModel();
		
		tableView.itemsProperty().bind(model.listProperty());
		tableView.setPlaceholder(new Label(""));
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
		spinner.visibleProperty().bind(model.loadingProperty());
		
		model.setOnMessage(AlertUtil::queueToast);
		model.load();
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
