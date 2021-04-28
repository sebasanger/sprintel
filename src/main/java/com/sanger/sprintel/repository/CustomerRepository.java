package com.sanger.sprintel.repository;

import com.sanger.sprintel.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
