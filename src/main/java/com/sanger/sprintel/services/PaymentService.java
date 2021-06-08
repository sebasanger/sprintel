package com.sanger.sprintel.services;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

import com.sanger.sprintel.dto.payment.CreatePaymentDto;
import com.sanger.sprintel.error.exceptions.EntityNotFoundException;
import com.sanger.sprintel.model.Payment;
import com.sanger.sprintel.model.PaymentMethod;
import com.sanger.sprintel.model.Register;
import com.sanger.sprintel.model.Stay;
import com.sanger.sprintel.model.UserEntity;
import com.sanger.sprintel.repository.PaymentRepository;
import com.sanger.sprintel.services.base.BaseService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService extends BaseService<Payment, Long, PaymentRepository> {
    private final StayService stayService;
    private final PaymentMethodService paymentMethodService;
    private final RegisterService registerService;

    public Optional<Set<Payment>> findByStay(Long stayId) {
        Stay stay = stayService.findById(stayId).orElseThrow(() -> new EntityNotFoundException());
        return this.repository.findByStay(stay);
    }

    public Payment savePayment(CreatePaymentDto createPaymentDto, UserEntity user) {

        Payment payment = new Payment();

        payment.setUser(user);
        payment.setDescription(createPaymentDto.getDescription());
        payment.setAmount(createPaymentDto.getAmount());

        // Set register active
        Register register = registerService.findActiveRegister();
        payment.setRegister(register);

        // Set stay by id
        Stay stay = stayService.findById(createPaymentDto.getStayId())
                .orElseThrow(() -> new EntityNotFoundException("Stay not found"));
        payment.setStay(stay);

        // Set payment method by id
        PaymentMethod paymentMethod = paymentMethodService.findById(createPaymentDto.getPaymentMethodId())
                .orElseThrow(() -> new EntityNotFoundException("Payment method not found"));
        payment.setPaymentMethod(paymentMethod);

        return save(payment);

    }

    public Page<Payment> filterAndPaginatePayments(Date date, Pageable pageable) {
        if (date == null) {
            return this.repository.findAll(pageable);
        } else {
            return this.repository.findByCreatedAt(date, pageable);
        }
    }

}
