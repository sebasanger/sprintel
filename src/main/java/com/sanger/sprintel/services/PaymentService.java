package com.sanger.sprintel.services;

import java.util.Optional;
import java.util.Set;

import com.sanger.sprintel.error.exceptions.EntityNotFoundException;
import com.sanger.sprintel.model.Payment;
import com.sanger.sprintel.model.PaymentMethod;
import com.sanger.sprintel.model.Register;
import com.sanger.sprintel.model.Stay;
import com.sanger.sprintel.model.UserEntity;
import com.sanger.sprintel.repository.PaymentRepository;
import com.sanger.sprintel.services.base.BaseService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService extends BaseService<Payment, Long, PaymentRepository> {
    private final StayService stayService;
    private final UserEntityService userEntityService;
    private final PaymentMethodService paymentMethodService;
    private final RegisterService registerService;

    public Optional<Set<Payment>> findByStay(Long stayId) {
        Stay stay = stayService.findById(stayId).orElseThrow(() -> new EntityNotFoundException());
        return this.repository.findByStay(stay);
    }

    public Payment savePayment(Payment payment) {

        // Set user by id
        Long userId = payment.getUser().getId();
        UserEntity user = userEntityService.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        payment.setUser(user);

        // Set register by id
        Long registerId = payment.getUser().getId();
        Register register = registerService.findById(registerId)
                .orElseThrow(() -> new EntityNotFoundException("Register not found"));
        payment.setRegister(register);

        // Set stay by id
        Long stayId = payment.getUser().getId();
        Stay stay = stayService.findById(stayId).orElseThrow(() -> new EntityNotFoundException("Stay not found"));
        payment.setStay(stay);

        // Set payment method by id
        Long paymentMethodId = payment.getUser().getId();
        PaymentMethod paymentMethod = paymentMethodService.findById(paymentMethodId)
                .orElseThrow(() -> new EntityNotFoundException("Payment method not found"));
        payment.setPaymentMethod(paymentMethod);

        return save(payment);

    }
}
