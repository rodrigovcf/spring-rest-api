package com.springrest.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.api.model.Customer;
import com.springrest.domain.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@GetMapping
	public List<Customer> testRequest() {
		return customerRepository.findAll();
	}

	
	/*
	 * Version1
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Customer> find(@PathVariable Long customerId) {
		Optional<Customer> customer = customerRepository.findById(customerId);
		
		//If exist
		if(customer.isPresent())
			return ResponseEntity.ok(customer.get());
		
		return ResponseEntity.notFound().build();//Not exist - returns 404	
	}
	*/
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> findCustomer(@PathVariable Long customerId) {
		return customerRepository.findById(customerId)
//				.map(customer -> ResponseEntity.ok(customer))
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Customer addCustomer(@RequestBody Customer customer) { 
		return customerRepository.save(customer);
	}
	
	@PutMapping("/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId,
			@RequestBody Customer customer){
		if (!customerRepository.existsById(customerId)) {
			return ResponseEntity.notFound().build();
		}	 
		
		customer.setId(customerId);
		customer = customerRepository.save(customer);
		
		return ResponseEntity.ok(customer);
	}
	
}
