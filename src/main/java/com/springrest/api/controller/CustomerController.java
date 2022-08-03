package com.springrest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.api.model.Customer;
import com.springrest.domain.repository.CustomerRepository;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@GetMapping("/customers")
	public List<Customer> testRequest() {
		return customerRepository.findAll();
	}

	
	
	
}
