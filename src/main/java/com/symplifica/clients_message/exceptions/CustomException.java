package com.symplifica.clients_message.exceptions;

import org.springframework.http.HttpStatus;


public class CustomException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int code;
	private final String description;
	private final HttpStatus httpStatus;
	
	public CustomException(ExceptionDescriptions exception, HttpStatus status) {
        super();
        this.code = exception.getCode();
        this.description = exception.getDescription();
		this.httpStatus = status;
    }
	
	public CustomException(String code, String description, HttpStatus status) {
        super();
        this.code = Integer.parseInt(code);
        this.description = description;
		this.httpStatus = status;
    }

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	
}
