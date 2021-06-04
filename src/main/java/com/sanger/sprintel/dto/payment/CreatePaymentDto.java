package com.sanger.sprintel.dto.payment;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePaymentDto {

	@NotNull
	private Double amount;

	@NotNull
	private String description;

	@NotNull
	private Long stayId;

	@NotNull
	private Long paymentMethodId;

}
