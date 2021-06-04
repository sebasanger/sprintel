package com.sanger.sprintel.dto.consumption;

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
public class CreateUpdateConsumptionDto {

	private Long id;

	@NotNull
	private Short amount;

	@NotNull
	private Long stayId;

	@NotNull
	private Long productId;

	private Long paymentMethodId;

	private Long paid;

}
