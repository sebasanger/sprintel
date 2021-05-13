package com.sanger.sprintel.services;

import com.sanger.sprintel.model.Customer;
import com.sanger.sprintel.repository.CustomerRepository;
import com.sanger.sprintel.services.base.BaseService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseService<Customer, Long, CustomerRepository> {
    public Page<Customer> filterAndPaginateCustomer(String filter, Pageable pageable) {
        return this.repository
                .findByNameIgnoreCaseContainingOrSurnameIgnoreCaseContainingOrEmailIgnoreCaseContainingOrDniIgnoreCaseContaining(
                        filter, filter, filter, filter, pageable);
    }
}
