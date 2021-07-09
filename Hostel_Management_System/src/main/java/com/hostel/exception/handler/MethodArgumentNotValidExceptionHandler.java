package com.hostel.exception.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class MethodArgumentNotValidExceptionHandler {
	public static class Error {
		private int errorCode;
		private String error;
		private String message;
		private List<String> fieldErrors = new ArrayList();

		public Error(HttpStatus status, String message, List<String> fieldErrors) {
			this.errorCode = status.value();
			this.error = status.name();
			this.message = message;
			this.fieldErrors = fieldErrors;
		}

		public int getErrorCode() {
			return errorCode;
		}

		public void setErrorCode(int errorCode) {
			this.errorCode = errorCode;
		}

		public String getError() {
			return error;
		}

		public void setError(String error) {
			this.error = error;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public List<String> getFieldErrors() {
			return fieldErrors;
		}

		public void setFieldErrors(List<String> fieldErrors) {
			this.fieldErrors = fieldErrors;
		}

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public Error handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest req) {
		BindingResult result = ex.getBindingResult();
		List<String> errorList = new ArrayList<>();
		result.getFieldErrors().forEach((fieldError) -> {
			errorList.add(fieldError.getObjectName() + "." + fieldError.getField() + " : "
					+ fieldError.getDefaultMessage() + " : rejected value [" + fieldError.getRejectedValue() + "]");
		});
		result.getGlobalErrors().forEach((fieldError) -> {
			errorList.add(fieldError.getObjectName() + " : " + fieldError.getDefaultMessage());
		});

		return new Error(HttpStatus.BAD_REQUEST, ex.getMessage(), errorList);
	}

}