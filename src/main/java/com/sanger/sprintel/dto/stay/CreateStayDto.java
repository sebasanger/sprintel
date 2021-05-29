package com.sanger.sprintel.dto.stay;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.sanger.sprintel.model.Customer;
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
public class CreateStayDto {

	@NotNull
	private Set<@Valid @NotNull Customer> customers;

	@NotNull
	private Long roomId;

	private Long paymentMethodId;

	private Long reasonId;

	@NotNull
	private Long roomPriceId;

	@NotNull
	private Short totalGuest;

	private Double paid;

	@NotNull
	private LocalDate entryDate;

	@NotNull
	private LocalDate outDate;

	private boolean active;

	private LocalDate checkIn;

	private LocalDate checkOut;

}
