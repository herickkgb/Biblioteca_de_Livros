package com.herick.book.exceptions;

public class ObjectNotFoundExceptions extends RuntimeException {

	private static final long serialVersionUID = 627613808796482798L;

	public ObjectNotFoundExceptions(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ObjectNotFoundExceptions(String message) {
		super(message);
		
	}

}
