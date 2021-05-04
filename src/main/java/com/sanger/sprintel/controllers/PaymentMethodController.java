package com.sanger.sprintel.controllers;

import com.sanger.sprintel.model.PaymentMethod;
import com.sanger.sprintel.services.PaymentMethodService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/payment-method")
@RequiredArgsConstructor
public class PaymentMethodController extends BaseController<PaymentMethod, Long, PaymentMethodService> {

}
