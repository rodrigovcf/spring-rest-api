package com.springrest.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@GetMapping("/customers")
	public String testRequest() {
		return "Test!!!";
	}

}
