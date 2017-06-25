package com.ssp.assigmnents.sizecalculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ssp.assigmnents.sizecalculator.domain.RestApiProblem;

@ControllerAdvice
public class ExceptionMapper {

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody RestApiProblem handle(IllegalArgumentException e) {
		return RestApiProblem.of(400, e.getMessage());
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody RestApiProblem handle(RequestException e) {
		return e.toApiProblem();
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody RestApiProblem handle(RequestNotFound e) {
		return e.toApiProblem();
	}
}
