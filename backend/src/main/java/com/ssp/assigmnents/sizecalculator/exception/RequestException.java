package com.ssp.assigmnents.sizecalculator.exception;

import com.ssp.assigmnents.sizecalculator.domain.RestApiProblem;

public class RequestException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private final String message;
	private final int responseCode;
	
	
	public RequestException(final String message, int responseCode) {
		this.message = message;
		this.responseCode = responseCode;
	}
	
	public RestApiProblem toApiProblem() {
		return RestApiProblem.of(responseCode, message);
	}
}
