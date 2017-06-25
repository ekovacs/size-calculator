package com.ssp.assigmnents.exception;

public class RequestNotFound extends RequestException {

	private static final long serialVersionUID = 1L;

	public RequestNotFound(String message) {
		super(message, 404);
	}
}
