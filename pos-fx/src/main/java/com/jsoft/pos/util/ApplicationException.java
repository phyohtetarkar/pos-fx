package com.jsoft.pos.util;

public class ApplicationException extends RuntimeException {
	private static final long serialVersionUID = 149516560515915294L;

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationException(String message) {
		super(message);
	}

}
