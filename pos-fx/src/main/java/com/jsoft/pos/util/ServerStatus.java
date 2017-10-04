package com.jsoft.pos.util;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class ServerStatus {

	public static final String CONNECTION_ERROR = "Error connecting with server!";

	public static boolean isReachable() {

		try {
			URLConnection conn = new URL(Utils.BASE_URL).openConnection();
			conn.connect();
			return true;
		} catch (IOException e) {
			
		}

		return false;
	}
}
