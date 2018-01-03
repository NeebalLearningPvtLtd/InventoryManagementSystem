package com.kossine.ims.repository.exceptions;

@SuppressWarnings("serial")
public class IntegrityConstraintViolationException extends Exception {

	public IntegrityConstraintViolationException(String msg) {
		super(msg);
	}

	public IntegrityConstraintViolationException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
