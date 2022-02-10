package com.api.feignclient.client;

import static com.api.feignclient.constants.ClientConstants.FeignClientConfig.FEIGNCLIENT_NAME;
import static com.api.feignclient.constants.ClientConstants.FeignClientConfig.FEIGNCLIENT_URL;
import static com.api.feignclient.constants.ClientConstants.FeignClientEndpoints.V1_CUSTOMERS_CUSTOMER;
import static com.api.feignclient.constants.ClientConstants.FeignClientEndpoints.V1_CUSTOMERS_CUSTOMER_ID;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.api.feignclient.dto.CustomerDTO;

@FeignClient(name = FEIGNCLIENT_NAME, url = FEIGNCLIENT_URL)
public interface CustomerClient {

	
	@GetMapping(value = V1_CUSTOMERS_CUSTOMER)
	public List<CustomerDTO> findCustomers();
	
	@GetMapping(value = V1_CUSTOMERS_CUSTOMER_ID)
	public CustomerDTO findCustomerById(@PathVariable long id);
	
	@PostMapping(value = V1_CUSTOMERS_CUSTOMER, consumes = "application/json")
	public CustomerDTO createCustomer(CustomerDTO customerDTO);
	
	@PutMapping(value = V1_CUSTOMERS_CUSTOMER_ID, consumes = "application/json")
	public CustomerDTO updateCustomer(@PathVariable long id, CustomerDTO customerDTO);
	
	@DeleteMapping(value = V1_CUSTOMERS_CUSTOMER_ID)
	public void removeCustomer(@PathVariable long id);

}
