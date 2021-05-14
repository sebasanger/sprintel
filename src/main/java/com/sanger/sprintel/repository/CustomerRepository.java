package com.sanger.sprintel.repository;

import java.util.Optional;

import com.sanger.sprintel.model.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Page<Customer> findByNameIgnoreCaseContainingOrSurnameIgnoreCaseContainingOrEmailIgnoreCaseContainingOrDniIgnoreCaseContaining(
            String name, String surname, String email, String dni, Pageable pageable);

    Optional<Customer> findByEmailAndIdNot(String email, Long id);

    Optional<Customer> findByDniAndIdNot(String dni, Long id);
}
