package com.sanger.sprintel.dto.stay;

import java.time.LocalDateTime;
import java.util.Date;

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
	private Date checkIn;
	private Date checkOut;
	private Boolean active;
	private String reason;
	private Double price;
	private Double pricePerDay;
	private Double paid;
	private Double totalToPay;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}
