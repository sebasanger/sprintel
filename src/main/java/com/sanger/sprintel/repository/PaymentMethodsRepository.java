package com.sanger.sprintel.repository;

import com.sanger.sprintel.model.PaymentMethod;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodsRepository extends JpaRepository<PaymentMethod, Long> {

}
