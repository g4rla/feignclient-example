package com.api.feignclient.client;

import static com.api.feignclient.constants.ClientConstants.FeignClientConfig.FEIGNCLIENT_NAME;
import static com.api.feignclient.constants.ClientConstants.FeignClientConfig.FEIGNCLIENT_URL;
import static com.api.feignclient.constants.ClientConstants.FeignClientEndpoints.V1_CUSTOMERS_CUSTOMER;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.api.feignclient.dto.CustomerDTO;

@FeignClient(name = FEIGNCLIENT_NAME, url = FEIGNCLIENT_URL)
public interface CustomerClient {

	
	@GetMapping(value = V1_CUSTOMERS_CUSTOMER)
	public List<CustomerDTO> findCustomers();

}
