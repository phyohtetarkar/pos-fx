package com.jsoft.pos.util;

import java.time.format.DateTimeFormatter;

public final class Utils {

	public static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
	public static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	public static final String BASE_URL = "http://localhost:8080/pos/";
	
}
