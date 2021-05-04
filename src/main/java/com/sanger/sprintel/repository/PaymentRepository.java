package com.sanger.sprintel.repository;

import java.util.Optional;
import java.util.Set;

import com.sanger.sprintel.model.Payment;
import com.sanger.sprintel.model.Stay;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Optional<Set<Payment>> findByStay(Stay stay);
}
