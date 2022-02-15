package com.api.feignclient.client.config;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.api.feignclient.exceptions.CustomerNotFoundException;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomerClientDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {
		int statusCode = response.status();
		if (statusCode == NOT_FOUND.value())
			return new CustomerNotFoundException("Customer not found");
		return null;
	}
}
