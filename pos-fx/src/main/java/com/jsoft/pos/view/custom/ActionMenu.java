package com.jsoft.pos.view.custom;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.shape.SVGPath;

public class ActionMenu {
	
	private ContextMenu contextMenu;
	private MenuItem edit;
	private MenuItem delete;
	
	private ActionMenu() {
		contextMenu = new ContextMenu();
		contextMenu.getStyleClass().add("context-menu");
		SVGPath pEdit = new SVGPath();
		pEdit.setContent("M15.539 5.273l-1.371 1.371-2.813-2.813 1.371-1.371c0.281-0.281 "
				+ "0.773-0.281 1.055 0l1.758 1.758c0.281 0.281 0.281 0.773 0 1.055zM2.25 "
				+ "12.938l8.297-8.297 2.813 2.813-8.297 8.297h-2.813v-2.813z");
		edit = new MenuItem("  Edit");
		edit.setGraphic(pEdit);
		
		SVGPath pDel = new SVGPath();
		pDel.setContent("M14.238 2.988v1.512h-10.477v-1.512h2.602l0.773-0.738h3.727l0.773 "
				+ "0.738h2.602zM4.5 14.238v-9h9v9c0 0.809-0.703 1.512-1.512 1.512h-5.977c-"
				+ "0.809 0-1.512-0.703-1.512-1.512z");
		delete = new MenuItem("  Delete");
		delete.setGraphic(pDel);
		
		contextMenu.getItems().addAll(edit, delete);
	}
	
	public static ActionMenu builder() {
		return new ActionMenu();
	}
	
	public ContextMenu build() {
		return contextMenu;
	}
	
	public ActionMenu onEdit(EventHandler<ActionEvent> evt) {
		edit.setOnAction(evt);
		return this;
	}
	
	public ActionMenu onDelete(EventHandler<ActionEvent> evt) {
		delete.setOnAction(evt);
		return this;
	}
}
