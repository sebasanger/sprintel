package com.sanger.sprintel.services;

import java.util.Optional;
import java.util.Set;

import com.sanger.sprintel.dto.customer.CheckDniIsValidDto;
import com.sanger.sprintel.dto.user.CheckEmailIsValidDto;
import com.sanger.sprintel.error.exceptions.EntityNotFoundException;
import com.sanger.sprintel.model.Customer;
import com.sanger.sprintel.model.InvoiceType;
import com.sanger.sprintel.model.Stay;
import com.sanger.sprintel.repository.CustomerRepository;
import com.sanger.sprintel.services.base.BaseService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService extends BaseService<Customer, Long, CustomerRepository> {
    private final InvoiceTypeService invoiceTypeService;

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

    public Customer saveCustomer(Customer customer) {
        // Set invoice type by id
        if (customer.getInvoiceType() != null) {
            InvoiceType invoiceType = invoiceTypeService.findById(customer.getInvoiceType().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Invoice type not found"));
            customer.setInvoiceType(invoiceType);
        }

        return this.repository.save(customer);
    }

    public Set<Stay> getCustomerStays(Long id) {

        Customer customer = this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException());

        return customer.getStays();
    }
}
