package com.jsoft.pos.view.form;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jsoft.pos.domain.Category;
import com.jsoft.pos.domain.Item;
import com.jsoft.pos.util.Navigator;
import com.jsoft.pos.util.ProgressRequestBody.UploadCallback;
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
		
		model.setOnSaveComplete(this::back);
		
		LoadingDialogView.init("Saving...", model.loadingProperty());
		
		Platform.runLater(name::requestFocus);
		
		model.itemWrapper().photoProperty().addListener((v, ov, nv) -> {
			imageView.setImage(new Image(nv, true));
		});
		
		model.init();
	}
	
	public void setItem(Item item) {
		model.itemWrapper().setItem(item);
		imageView.setImage(new Image(model.itemWrapper().photoProperty().get(), true));
	}

	public void save() {
		model.save();
	}
	
	public void chooseImage() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Choose Image");
		/*fileChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("PNG", "*.png"),
				new FileChooser.ExtensionFilter("JPG", "*.jpg"));*/
		
		File image = fileChooser.showOpenDialog(imageView.getScene().getWindow());
		
		System.out.println(image.getAbsolutePath());
		progressContainer.setVisible(true);
		model.upload(image, new UploadCallback() {
			
			@Override
			public void onProgressUpdate(double value) {
				progress.setProgress(value);
			}
			
			@Override
			public void onFinished() {
				progress.setProgress(1);
				progressContainer.setVisible(false);
			}
			
			@Override
			public void onError() {
				progressContainer.setVisible(false);
			}
		});
	}
	
	public void back() {
		Navigator.navigate("Items");
		Navigator.setNavTitle("Items");
	}
}
