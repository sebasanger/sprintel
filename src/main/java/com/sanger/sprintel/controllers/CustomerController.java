package com.sanger.sprintel.controllers;

import com.sanger.sprintel.model.Customer;
import com.sanger.sprintel.services.CustomerService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController extends BaseController<Customer, Long, CustomerService> {

}
