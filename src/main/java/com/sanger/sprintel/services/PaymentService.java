package com.sanger.sprintel.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

        if (createPaymentDto.getDescription() != null) {
            payment.setDescription(createPaymentDto.getDescription());
        } else {
            payment.setDescription("Pay for stay " + createPaymentDto.getStayId());

        }

        return save(payment);

    }

    public Page<Payment> filterAndPaginatePayments(String start, String end, Pageable pageable) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        if (start.length() > 0 && end.length() > 0) {
            LocalDateTime startDate = LocalDateTime.parse(start, formatter);
            LocalDateTime endDate = LocalDateTime.parse(end, formatter);

            return this.repository.findByCreatedAtBetween(startDate, endDate, pageable);
        } else {
            return this.repository.findAll(pageable);
        }
    }

}
