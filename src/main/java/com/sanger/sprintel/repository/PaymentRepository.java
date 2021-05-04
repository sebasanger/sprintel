package com.sanger.sprintel.repository;

import com.sanger.sprintel.model.Payment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
