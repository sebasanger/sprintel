package com.sanger.sprintel.services;

import com.sanger.sprintel.model.Customer;
import com.sanger.sprintel.repository.CustomerRepository;
import com.sanger.sprintel.services.base.BaseService;

import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseService<Customer, Long, CustomerRepository> {

}
