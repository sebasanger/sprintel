package com.sanger.sprintel.controllers;

import java.util.Date;
import java.util.Set;

import javax.validation.Valid;

import com.sanger.sprintel.dto.payment.CreatePaymentDto;
import com.sanger.sprintel.dto.payment.GetPaymentPaginatedDto;
import com.sanger.sprintel.dto.payment.PaymentDtoConverter;
import com.sanger.sprintel.error.exceptions.EntityNotFoundException;
import com.sanger.sprintel.model.Payment;
import com.sanger.sprintel.model.UserEntity;
import com.sanger.sprintel.services.PaymentService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController extends BaseController<Payment, Long, PaymentService> {

    private final PaymentService paymentService;

    private final PaymentDtoConverter paymentDtoConverter;

    @PostMapping("/save")
    public ResponseEntity<Payment> create(@Valid @RequestBody CreatePaymentDto newPayment,
            @AuthenticationPrincipal UserEntity user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.savePayment(newPayment, user));
    }

    @GetMapping("/findByStay/{id}")
    public ResponseEntity<?> findByEntityId(@PathVariable Long id) {
        Set<Payment> result = service.findByStay(id).orElseThrow(() -> new EntityNotFoundException());
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/paginate-filter")
    public ResponseEntity<?> paginateAndFilterPayments(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.DESC) Pageable pageable,
            @RequestAttribute(required = false, name = "date") Date date) {

        Page<Payment> result = paymentService.filterAndPaginatePayments(date, pageable);

        if (result.isEmpty()) {
            throw new EntityNotFoundException();
        } else {
            Page<GetPaymentPaginatedDto> dtoList = result
                    .map(paymentDtoConverter::convertPaymentToGetPaymentPaginatedDto);

            return ResponseEntity.ok().body(dtoList);

        }
    }

}
