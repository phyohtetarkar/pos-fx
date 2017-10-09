package com.jsoft.pos.view.form;

import java.io.File;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jsoft.pos.domain.Category;
import com.jsoft.pos.domain.Item;
import com.jsoft.pos.util.AlertUtil;
import com.jsoft.pos.util.Navigator;
import com.jsoft.pos.util.Utils;
import com.jsoft.pos.view.LoadingDialogView;
import com.jsoft.pos.view.model.ItemFormViewModel;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;

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
	@FXML
	private HBox progressContainer;
	@FXML
	private ProgressIndicator progress;
	@FXML
	private JFXButton saveButton;

	private ItemFormViewModel model;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model = new ItemFormViewModel();

		setupValidators();

		model.itemWrapper().nameProperty().bindBidirectional(name.textProperty());
		model.itemWrapper().codeProperty().bindBidirectional(code.textProperty());
		model.itemWrapper().purchasePriceProperty().bindBidirectional(purchasePrice.textProperty());
		model.itemWrapper().retailPriceProperty().bindBidirectional(retailPrice.textProperty());
		model.itemWrapper().quantityProperty().bindBidirectional(quantity.textProperty());
		model.itemWrapper().remarkProperty().bindBidirectional(remark.textProperty());
		model.itemWrapper().categoryProperty().bindBidirectional(categories.valueProperty());
		
		categories.itemsProperty().bind(model.categoriesProperty());
		progress.progressProperty().bind(model.uploadProperty());
		progressContainer.visibleProperty().bind(model.uploadProperty().greaterThan(0).and(model.uploadProperty().lessThan(1)));

		LoadingDialogView.init("Saving...", model.loadingProperty());

		Platform.runLater(name::requestFocus);

		model.itemWrapper().photoProperty().addListener((v, ov, nv) -> {
			imageView.setImage(new Image(nv, true));
		});
		
		model.setOnSaveComplete(this::back);
		model.setOnMessage(AlertUtil::queueToast);
		model.init();
	}

	private void setupValidators() {
		name.getValidators().add(Utils.requiredValidator());
		code.getValidators().add(Utils.requiredValidator());
		purchasePrice.getValidators().addAll(Utils.requiredValidator(), Utils.numberValidator());
		retailPrice.getValidators().addAll(Utils.requiredValidator(), Utils.numberValidator());
		quantity.getValidators().addAll(Utils.requiredValidator(), Utils.numberValidator());
		
		name.textProperty().addListener((v, ov, nv) -> name.validate());
		code.textProperty().addListener((v, ov, nv) -> code.validate());
		purchasePrice.textProperty().addListener((v, ov, nv) -> purchasePrice.validate());
		retailPrice.textProperty().addListener((v, ov, nv) -> retailPrice.validate());
		quantity.textProperty().addListener((v, ov, nv) -> quantity.validate());
	}

	public void setItem(Item item) {
		model.itemWrapper().setItem(item);
		if (Objects.nonNull(item.getPhoto())) {
			imageView.setImage(new Image(model.itemWrapper().photoProperty().get(), true));
		}
	}

	public void save() {
		if (name.validate() & 
				code.validate() & 
				purchasePrice.validate() & 
				retailPrice.validate() & 
				quantity.validate()) {
			
			model.save();
		}
	}

	public void chooseImage() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Choose Image");
		/*
		 fileChooser.getExtensionFilters().addAll( new
		  	FileChooser.ExtensionFilter("PNG", "*.png"), new
		 	FileChooser.ExtensionFilter("JPG", "*.jpg"));
		 */

		File image = fileChooser.showOpenDialog(imageView.getScene().getWindow());
		model.upload(image);
	}

	public void back() {
		Navigator.navigate("Items");
		Navigator.setNavTitle("Items");
	}
}
