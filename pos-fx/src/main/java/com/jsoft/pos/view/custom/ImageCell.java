package com.jsoft.pos.view.custom;

import javafx.scene.control.TableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class ImageCell<S> extends TableCell<S, String>{
	
	private ImageView imageView;
	private VBox frame;
	
	public ImageCell(String placeholder) {
		frame = new VBox();
		frame.setMaxSize(82, 82);
		
		imageView = new ImageView(new Image(ImageCell.class.getResource(placeholder.concat(".png")).toExternalForm(), 80, 80, true, true));
		imageView.setFitHeight(82);
		imageView.setFitWidth(82);
		
		frame.getChildren().add(imageView);
	}

	@Override
	protected void updateItem(String item, boolean empty) {
		super.updateItem(item, empty);
		
		if (!empty) {
			
			if (item != null && !item.isEmpty()) {
				imageView.setImage(new Image(item, 80, 80, true, true, true));
			}
			
			setGraphic(frame);
		} else {
			setGraphic(null);
		}
		
	}
	
}
