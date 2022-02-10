package com.api.feignclient.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.api.feignclient.dto.CustomerDTO;

@FeignClient(name = "customer", url = "https://62044585c6d8b20017dc34af.mockapi.io")
public interface CustomerClient {

	@GetMapping(value = "/v1/customers/customer")
	public List<CustomerDTO> findCustomers();

}
