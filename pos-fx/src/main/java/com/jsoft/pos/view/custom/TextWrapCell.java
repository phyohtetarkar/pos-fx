package com.jsoft.pos.view.custom;

import javafx.scene.control.Control;
import javafx.scene.control.TableCell;
import javafx.scene.text.Text;

public class TextWrapCell<S> extends TableCell<S, String> {
	private Text text;
	
	public TextWrapCell() {
		text = new Text();
	}

	@Override
	protected void updateItem(String item, boolean empty) {
		super.updateItem(item, empty);

		if (!empty) {
			try {
				setPrefHeight(Control.USE_COMPUTED_SIZE);
				text.wrappingWidthProperty().bind(widthProperty().subtract(35));
				text.textProperty().setValue(item);
				setGraphic(text);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			setGraphic(null);
			setText(null);
		}
	}

}
