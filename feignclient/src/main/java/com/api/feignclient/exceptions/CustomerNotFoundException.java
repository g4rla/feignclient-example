package com.api.feignclient.exceptions;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6456740176914501019L;
	
	public CustomerNotFoundException(String message){
		super(message);
	}
}
