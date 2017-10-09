package com.jsoft.pos.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jsoft.pos.domain.Category;
import com.jsoft.pos.domain.Item;
import com.jsoft.pos.util.AlertUtil;
import com.jsoft.pos.util.Navigator;
import com.jsoft.pos.view.custom.ActionMenu;
import com.jsoft.pos.view.custom.ImageCell;
import com.jsoft.pos.view.custom.TextWrapCell;
import com.jsoft.pos.view.form.ItemFormView;
import com.jsoft.pos.view.model.ItemsViewModel;
import com.jsoft.pos.view.model.PagableViewModel;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class ItemsView extends PagableView<Item> {

	@FXML
	private TableColumn<Item, String> imageColumn;
	@FXML
	private TableColumn<Item, String> nameColumn;
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
		
		tableView.setContextMenu(ActionMenu.builder()
				.onEdit(e -> {
					Item item = tableView.getSelectionModel().getSelectedItem();
					ItemFormView form = Navigator.navigateAndWait("form/ItemForm");
					Navigator.setNavTitle("Edit Item");
					Platform.runLater(() -> {
						form.setItem(item);
					}); 
					
				})
				.onDelete(e -> {
					Item item = tableView.getSelectionModel().getSelectedItem();
					if (AlertUtil.showConfirm("Are you sure to delete?")) {
						model.delete(item);
					}
				})
				.build());

		model.categoryProperty().bind(categories.getSelectionModel().selectedItemProperty());
		model.codeProperty().bind(code.textProperty());
		model.nameProperty().bind(name.textProperty());
		
		imageColumn.setCellFactory(c -> new ImageCell<>("item"));
		nameColumn.setCellFactory(c -> new TextWrapCell<>());
		
		super.initialize(location, resources);
	}
	
	public void add() {
		Navigator.navigate("form/ItemForm");
		Navigator.setNavTitle("New Item");
	}
	
	public void clear() {
		categories.getSelectionModel().clearSelection();
		code.clear();
		name.clear();
	}

	
}
