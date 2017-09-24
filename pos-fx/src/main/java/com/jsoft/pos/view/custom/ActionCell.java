package com.jsoft.pos.view.custom;

import com.jfoenix.controls.JFXRippler;
import com.jfoenix.controls.JFXRippler.RipplerMask;
import com.jfoenix.controls.JFXRippler.RipplerPos;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Paint;
import javafx.scene.shape.SVGPath;

public class ActionCell<T> extends TableCell<T, String> {
	
	private SVGPath path;
	private Label label;
	private JFXRippler rippler;
	
	public ActionCell() {
		path = new SVGPath();
		path.setContent("M12 15.984c1.078 0 2.016 0.938 2.016 2.016s-0.938 2.016-2.016 "
				+ "2.016-2.016-0.938-2.016-2.016 0.938-2.016 2.016-2.016zM12 9.984c1.078 "
				+ "0 2.016 0.938 2.016 2.016s-0.938 2.016-2.016 2.016-2.016-0.938-2.016-2.016 "
				+ "0.938-2.016 2.016-2.016zM12 8.016c-1.078 0-2.016-0.938-2.016-2.016s0.938-"
				+ "2.016 2.016-2.016 2.016 0.938 2.016 2.016-0.938 2.016-2.016 2.016z");
		
		path.setFill(Paint.valueOf("#757575"));
		
		label = new Label();
		label.setGraphic(path);
		label.setTooltip(new Tooltip("Action"));
		label.setAlignment(Pos.CENTER);
		label.setPrefSize(50, 50);
		
		rippler = new JFXRippler(label, RipplerMask.CIRCLE, RipplerPos.FRONT);
		rippler.setMaxWidth(50);
		rippler.getStyleClass().add("icons-rippler");
		rippler.setOnMouseClicked(evt -> {
			System.out.println(getIndex());
		});
	}

	@Override
	protected void updateItem(String item, boolean empty) {
		super.updateItem(item, empty);
		
		if (!empty) {
			setGraphic(rippler);
		} else {
			setGraphic(null);
		}
	}
}
