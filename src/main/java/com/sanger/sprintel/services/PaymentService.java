package com.sanger.sprintel.services;

import com.sanger.sprintel.model.Payment;
import com.sanger.sprintel.repository.PaymentRepository;
import com.sanger.sprintel.services.base.BaseService;

import org.springframework.stereotype.Service;

@Service
public class PaymentService extends BaseService<Payment, Long, PaymentRepository> {

}
