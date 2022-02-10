package com.api.feignclient.controller;

import static com.api.feignclient.constants.CustomerControllerConstants.ControllerEndpoints.CUSTOMERS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.feignclient.client.CustomerClient;
import com.api.feignclient.dto.CustomerDTO;

@RestController
@RequestMapping(CUSTOMERS)
public class CustomerController {
	
	@Autowired
	private CustomerClient customerClient;
	
	@GetMapping()
	public List<CustomerDTO> getCustomers() {
		return customerClient.findCustomers();
	}

}
