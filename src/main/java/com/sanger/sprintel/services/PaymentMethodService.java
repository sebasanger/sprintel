package com.sanger.sprintel.services;

import com.sanger.sprintel.model.PaymentMethod;
import com.sanger.sprintel.repository.PaymentMethodsRepository;
import com.sanger.sprintel.services.base.BaseService;

import org.springframework.stereotype.Service;

@Service
public class PaymentMethodService extends BaseService<PaymentMethod, Long, PaymentMethodsRepository> {

}
