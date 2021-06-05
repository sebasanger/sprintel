package com.sanger.sprintel.dto.payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetPaymentPaginatedDto {
	private Long id;
	private Double amount;
	private String description;
	private String paymentMethod;
	private Long registerId;
	private Long stayId;
	private String user;

}
