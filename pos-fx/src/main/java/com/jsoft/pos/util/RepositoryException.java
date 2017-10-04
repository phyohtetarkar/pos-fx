package com.jsoft.pos.util;

public class RepositoryException extends RuntimeException {
	private static final long serialVersionUID = 149516560515915294L;

	public RepositoryException(String message, Throwable cause) {
		super(message, cause);
	}

	public RepositoryException(String message) {
		super(message);
	}

}