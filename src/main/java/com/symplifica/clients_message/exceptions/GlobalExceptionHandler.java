package com.symplifica.clients_message.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

	@ResponseBody
	@ExceptionHandler(value = CustomException.class)
	public ResponseEntity<ErrorDTO> handlerException(CustomException exception) {
		return new ResponseEntity<>(new ErrorDTO(exception.getCode(), exception.getDescription()),
				exception.getHttpStatus());
	}

	@ResponseBody
	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ErrorDTO> handlerException(HttpRequestMethodNotSupportedException exception) {
		return new ResponseEntity<>(new ErrorDTO(ExceptionDescriptions.METHOD_NOT_ALLOWED.getCode(),
				ExceptionDescriptions.METHOD_NOT_ALLOWED.getDescription()), HttpStatus.METHOD_NOT_ALLOWED);
	}

	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorDTO> handlerException(Exception exception) {
		return new ResponseEntity<>(new ErrorDTO(ExceptionDescriptions.DEFAULT_EXCEPTION.getCode(),
				ExceptionDescriptions.DEFAULT_EXCEPTION.getDescription()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ResponseBody
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDTO> handlerException(MethodArgumentNotValidException exception) {
		return new ResponseEntity<>(new ErrorDTO(ExceptionDescriptions.BAD_REQUEST.getCode(),
				String.format(ExceptionDescriptions.BAD_REQUEST.getDescription(), exception.getBindingResult().getFieldErrors().get(exception.getBindingResult().getFieldErrors().size()-1).getDefaultMessage())), HttpStatus.BAD_REQUEST);
	}
}
