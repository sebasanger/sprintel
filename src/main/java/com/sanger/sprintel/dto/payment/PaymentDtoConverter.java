package com.sanger.sprintel.dto.payment;

import com.sanger.sprintel.model.Payment;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PaymentDtoConverter {

	public GetPaymentPaginatedDto convertPaymentToGetPaymentPaginatedDto(Payment payment) {
		return GetPaymentPaginatedDto.builder().id(payment.getId()).user(payment.getUser().getFullName())
				.amount(payment.getAmount()).stayId(payment.getStay().getId()).registerId(payment.getRegister().getId())
				.paymentMethod(payment.getPaymentMethod().getMethod()).build();
	}

}
