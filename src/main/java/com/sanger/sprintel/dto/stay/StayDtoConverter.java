package com.sanger.sprintel.dto.stay;

import com.sanger.sprintel.model.Stay;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StayDtoConverter {

	public GetStayPaginatedDto convertStayToStayPaginatedDto(Stay stay) {
		return GetStayPaginatedDto.builder().id(stay.getId()).active(stay.isActive()).checkIn(stay.getCheckIn())
				.checkOut(stay.getCheckOut()).createdAt(stay.getCreatedAt()).updatedAt(stay.getUpdatedAt())
				.entryDate(stay.getEntryDate()).outDate(stay.getOutDate()).paid(stay.getPaid())
				.price(stay.getRoomPrice().getPrice()).totalToPay(stay.getTotalToPay())
				.reason(stay.getReason().getReason()).room(stay.getRoom().getNumber()).totalGuest(stay.getTotalGuest())
				.pricePerDay(stay.getPricePerDay()).build();
	}

}
