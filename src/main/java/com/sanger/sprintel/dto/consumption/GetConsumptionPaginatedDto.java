package com.sanger.sprintel.dto.consumption;

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
public class GetConsumptionPaginatedDto {
	private Long id;
	private Short amount;
	private Double paid;
	private Double price;
	private String product;
	private Long stay;
	private String user;
	private LocalDateTime createdAt;

}
