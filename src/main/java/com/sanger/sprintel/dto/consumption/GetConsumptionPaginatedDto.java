package com.sanger.sprintel.dto.consumption;

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
public class GetConsumptionPaginatedDto {
	private Long id;
	private Short amount;
	private Boolean paid;
	private Double price;
	private String paymentMethod;
	private String product;
	private Long register;
	private Long stay;
	private String user;

}
