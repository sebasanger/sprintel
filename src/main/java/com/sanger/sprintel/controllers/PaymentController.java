package com.sanger.sprintel.controllers;

import com.sanger.sprintel.model.Payment;
import com.sanger.sprintel.services.PaymentService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController extends BaseController<Payment, Long, PaymentService> {

}
