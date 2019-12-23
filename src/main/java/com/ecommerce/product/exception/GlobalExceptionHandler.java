package com.ecommerce.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

	@ExceptionHandler(value = NoMatchListFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(NoMatchListFoundException exception) {
		ErrorResponse errorResponse = new ErrorResponse(exception.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_ACCEPTABLE);
	}
}
