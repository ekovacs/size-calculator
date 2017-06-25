package com.ssp.assigmnents.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Category doesn't belong to brand")
 public class InvalidCategoryConfiguration extends RequestException {

	private static final long serialVersionUID = 1L;

	public InvalidCategoryConfiguration(String message) {
		super(message, 400);
	}
 }