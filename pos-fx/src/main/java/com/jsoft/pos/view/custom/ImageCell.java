package com.jsoft.pos.view.custom;

import java.util.Objects;

import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class ImageCell<S> extends TableCell<S, String> {

	private ImageView imageView;
	private VBox frame;

	public ImageCell(String placeholder) {
		frame = new VBox();
		frame.setMinSize(100, 100);
		frame.setAlignment(Pos.CENTER);

		imageView = new ImageView(new Image(ImageCell.class.getResource(placeholder.concat(".png")).toExternalForm(), true));
		imageView.setFitHeight(100);
		imageView.setFitWidth(100);
		imageView.setPreserveRatio(true);
		imageView.setSmooth(true);

		frame.getChildren().add(imageView);
	}

	@Override
	protected void updateItem(String item, boolean empty) {
		super.updateItem(item, empty);

		if (!empty) {
			
			if (Objects.nonNull(item) && !item.isEmpty()) {
				// BufferedImage image = ImageIO.read(new URL(item));
				// SwingFXUtils.toFXImage(image, null);
				imageView.setImage(new Image(item, true));

			}

			setGraphic(frame);
		} else {
			setGraphic(null);
		}

	}

}
