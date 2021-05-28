package com.sanger.sprintel.services;

import java.util.Optional;

import com.sanger.sprintel.dto.customer.CheckDniIsValidDto;
import com.sanger.sprintel.dto.user.CheckEmailIsValidDto;
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

    public boolean checkEmailIsValid(CheckEmailIsValidDto checkEmailIsValidDto) {
        return this.repository.findByEmailAndIdNot(checkEmailIsValidDto.getEmail(), checkEmailIsValidDto.getId())
                .isPresent();

    }

    public Optional<Customer> checkDniIsValid(CheckDniIsValidDto checkDniIsValidDto) {

        return this.repository.findByDniAndIdNot(checkDniIsValidDto.getDni(), checkDniIsValidDto.getId());
    }
}
