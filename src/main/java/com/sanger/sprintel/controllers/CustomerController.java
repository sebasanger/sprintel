package com.sanger.sprintel.controllers;

import java.util.List;

import com.sanger.sprintel.error.exceptions.UserNotFoundException;
import com.sanger.sprintel.model.Customer;
import com.sanger.sprintel.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

	private final CustomerService customerService;

	@GetMapping("")
	public ResponseEntity<?> getUsers() {
		List<Customer> result = customerService.findAll();

		if (result.isEmpty()) {
			throw new UserNotFoundException();
		} else {
			return ResponseEntity.ok().body(result);
		}
	}

}
