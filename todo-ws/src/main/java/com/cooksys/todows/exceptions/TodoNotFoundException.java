package com.cooksys.todows.exceptions;

public class TodoNotFoundException extends RuntimeException {

	public TodoNotFoundException() {
		super();
	}

	public TodoNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TodoNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public TodoNotFoundException(String message) {
		super(message);
	}

	public TodoNotFoundException(Throwable cause) {
		super(cause);
	}
	

}
