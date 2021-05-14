package com.sanger.sprintel.controllers;

import com.sanger.sprintel.dto.customer.CheckDniIsValidDto;
import com.sanger.sprintel.dto.user.CheckEmailIsValidDto;
import com.sanger.sprintel.error.exceptions.EntityNotFoundException;
import com.sanger.sprintel.model.Customer;
import com.sanger.sprintel.services.CustomerService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController extends BaseController<Customer, Long, CustomerService> {

    private final CustomerService customerService;

    @GetMapping("/paginate-filter")
    public ResponseEntity<?> paginateAndFilterCustomers(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable,
            @RequestParam(defaultValue = "") String filter) {
        Page<Customer> result = customerService.filterAndPaginateCustomer(filter, pageable);

        if (result.isEmpty()) {
            throw new EntityNotFoundException();
        } else {
            return ResponseEntity.ok().body(result);
        }
    }

    @PostMapping("/checkEmailIsValid")
    public boolean checkEmailIsValid(@RequestBody CheckEmailIsValidDto checkEmailIsValidDto) {
        return customerService.checkEmailIsValid(checkEmailIsValidDto);
    }

    @PostMapping("/checkDniIsValid")
    public boolean checkDniIsValid(@RequestBody CheckDniIsValidDto checkDniIsValidDto) {
        return customerService.checkDniIsValid(checkDniIsValidDto);
    }
}
