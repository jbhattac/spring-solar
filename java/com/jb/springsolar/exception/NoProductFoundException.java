package com.jb.springsolar.exception;

public class NoProductFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoProductFoundException(String message) {
		super(message);
	}

}
