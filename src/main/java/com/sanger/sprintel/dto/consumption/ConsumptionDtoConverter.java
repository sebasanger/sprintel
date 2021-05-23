package com.sanger.sprintel.dto.consumption;

import com.sanger.sprintel.model.Consumption;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ConsumptionDtoConverter {

	public GetConsumptionPaginatedDto convertConsumptionToConsumptionPaginateDto(Consumption consumption) {
		return GetConsumptionPaginatedDto.builder().id(consumption.getId()).user(consumption.getUser().getFullName())
				.paid(consumption.getPaid()).amount(consumption.getAmount()).stay(consumption.getStay().getId())
				.price(consumption.getPrice()).product(consumption.getProduct().getName())
				.register(consumption.getRegister().getId()).paymentMethod(consumption.getPaymentMethod().getMethod())
				.build();
	}

}
