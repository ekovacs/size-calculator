package com.ssp.assigmnents.domain;

public class RestApiProblem {

	private final int httpCode;

	private final String message;

	private RestApiProblem(int httpCode, String message) {
		this.httpCode = httpCode;
		this.message = message;
	}

	public static RestApiProblem of(int httpCode, String message) {
		return new RestApiProblem(httpCode, message);
	}

	public int getHttpCode() {
		return httpCode;
	}

	public String getMessage() {
		return message;
	}
}
