package com.api.feignclient.controller;

import static com.api.feignclient.constants.CustomerControllerConstants.ControllerEndpoints.CUSTOMERS;
import static com.api.feignclient.constants.CustomerControllerConstants.ControllerEndpoints.ID;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping(ID)
	public CustomerDTO getCustomerById(@PathVariable long id) {
		return customerClient.findCustomerById(id);
	}
	
	@PostMapping()
	public ResponseEntity<CustomerDTO> postCustomer(@RequestBody CustomerDTO customerDTO) {
		return new ResponseEntity<>(customerClient.createCustomer(customerDTO), HttpStatus.CREATED);
	}
	
	@PutMapping(ID)
	public CustomerDTO putCustomer(@PathVariable long id, @RequestBody CustomerDTO customerDTO) {
		return customerClient.updateCustomer(id, customerDTO);
	}
	
	@DeleteMapping(ID)
	public void deleteCustomer(@PathVariable long id) {
		customerClient.removeCustomer(id);
	}
	
}
