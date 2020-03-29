/**
 * 
 */
package com.test.javaworkshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import enums.ErrorResponseEnum;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ CountryNotFoundException.class, DataBaseNotAvailableException.class })
	public ResponseEntity<ExceptionEntityResponse> handleException(Exception exception) {
		ExceptionEntityResponse response = new ExceptionEntityResponse();
		response.setTimeStamp(System.currentTimeMillis());
		response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value() + "");
		response.setMessage(exception.getMessage());
		return new ResponseEntity<ExceptionEntityResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionEntityResponse> handleGeneralException(Exception exception) {
		ExceptionEntityResponse response = new ExceptionEntityResponse();
		response.setTimeStamp(System.currentTimeMillis());
		response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value() + "");
		response.setMessage(ErrorResponseEnum.INTERNAL_ERROR.name());
		return new ResponseEntity<ExceptionEntityResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
