package com.jsoft.pos.view.form;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jsoft.pos.domain.Category;
import com.jsoft.pos.domain.Item;
import com.jsoft.pos.util.Navigator;
import com.jsoft.pos.view.LoadingDialogView;
import com.jsoft.pos.view.model.ItemFormViewModel;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

public class ItemFormView implements Initializable {
	
	@FXML
	private ImageView imageView;
	@FXML
	private JFXTextField name;
	@FXML
	private JFXTextField code;
	@FXML
	private JFXTextField purchasePrice;
	@FXML
	private JFXTextField retailPrice;
	@FXML
	private JFXTextField quantity;
	@FXML
	private JFXComboBox<Category> categories;
	@FXML
	private JFXTextArea remark;
	
	private ItemFormViewModel model;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model = new ItemFormViewModel();
		
		model.itemWrapper().nameProperty().bindBidirectional(name.textProperty());
		model.itemWrapper().codeProperty().bindBidirectional(code.textProperty());
		model.itemWrapper().purchasePriceProperty().bindBidirectional(purchasePrice.textProperty());
		model.itemWrapper().retailPriceProperty().bindBidirectional(retailPrice.textProperty());
		model.itemWrapper().quantityProperty().bindBidirectional(quantity.textProperty());
		model.itemWrapper().remarkProperty().bindBidirectional(remark.textProperty());
		
		categories.valueProperty().bindBidirectional(model.itemWrapper().categoryProperty());
		categories.itemsProperty().bind(model.categoriesProperty());
		
		model.setOnSaveCompleteListener(this::back);
		
		LoadingDialogView.init("Saving...", model.loadingProperty());
		
		Platform.runLater(name::requestFocus);
		
		model.init();
	}
	
	public void setItem(Item item) {
		model.itemWrapper().setItem(item);
	}

	public void save() {
		model.save();
	}
	
	public void back() {
		Navigator.navigate("Items");
		Navigator.setNavTitle("Items");
	}
}
