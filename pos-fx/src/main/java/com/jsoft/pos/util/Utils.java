package com.jsoft.pos.util;

import java.time.format.DateTimeFormatter;

import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;

public final class Utils {

	public static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
	public static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	public static final String BASE_URL = "http://localhost:8080/pos/";
	
	public static RequiredFieldValidator requiredValidator() {
		RequiredFieldValidator validator = new RequiredFieldValidator();
		validator.setMessage("Input required!");
		return validator;
	}
	
	public static NumberValidator numberValidator() {
		NumberValidator validator = new NumberValidator();
		validator.setMessage("Must be number only!");
		return validator;
	}
}
