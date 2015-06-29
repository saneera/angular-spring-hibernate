package com.angular.util.exception;

public class CrudException extends Exception {
	
	private static final long serialVersionUID = -9074634603923774421L;

	public CrudException(String message) {
		super(message);
	}

	public CrudException(String message, Throwable e) {
		super(message, e);
	}
}
