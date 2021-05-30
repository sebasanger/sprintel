package com.sanger.sprintel.dto.stay;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
public class GetStayPaginatedDto {

	private Long id;
	private String room;
	private Short totalGuest;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private LocalDate entryDate;
	private LocalDate outDate;
	private Boolean active;
	private String reason;
	private Double price;
	private Double pricePerDay;
	private Double paid;
	private Double totalToPay;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}
