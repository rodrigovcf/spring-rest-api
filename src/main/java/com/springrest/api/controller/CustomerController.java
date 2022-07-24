package com.springrest.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.api.model.Customer;

@RestController
public class CustomerController {
	
	@GetMapping("/customers")
	public List<Customer> testRequest() {
		var customer1 = new Customer();
		customer1.setId(1L);
		customer1.setName("Rodrigo");
		customer1.setEmail("rodrigo@springrest.com");
		customer1.setPhone("(88) 8888-8888");
		
		var customer2 = new Customer();
		customer2.setId(2L);
		customer2.setName("Pedro");
		customer2.setEmail("pedro@springrest.com");
		customer2.setPhone("(88) 8888-9999");
		
		
		return Arrays.asList(customer1, customer2) ;
	}

}
