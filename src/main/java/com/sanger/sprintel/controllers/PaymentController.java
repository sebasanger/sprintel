package com.sanger.sprintel.controllers;

import java.util.Set;

import javax.validation.Valid;

import com.sanger.sprintel.error.exceptions.EntityNotFoundException;
import com.sanger.sprintel.model.Payment;
import com.sanger.sprintel.services.PaymentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController extends BaseController<Payment, Long, PaymentService> {

    private final PaymentService paymentService;

    @PostMapping("/save")
    public ResponseEntity<Payment> create(@Valid @RequestBody Payment newPayment) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.savePayment(newPayment));
    }

    @GetMapping("/findByStay/{id}")
    public ResponseEntity<?> findByEntityId(@PathVariable Long id) {
        Set<Payment> result = service.findByStay(id).orElseThrow(() -> new EntityNotFoundException());
        return ResponseEntity.ok().body(result);
    }
}
