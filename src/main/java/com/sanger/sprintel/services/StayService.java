package com.sanger.sprintel.services;

import com.sanger.sprintel.error.exceptions.EntityNotFoundException;
import com.sanger.sprintel.model.Reason;
import com.sanger.sprintel.model.Room;
import com.sanger.sprintel.model.RoomPrice;
import com.sanger.sprintel.model.Stay;
import com.sanger.sprintel.repository.StayRepository;
import com.sanger.sprintel.services.base.BaseService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StayService extends BaseService<Stay, Long, StayRepository> {

    private final CustomerService customerService;
    private final RoomService roomService;
    private final ReasonService reasonService;
    private final RoomPriceService roomPriceService;

    public Stay saveStay(Stay stay) {

        // add the customers in the stay
        if (stay.getCustomers().isEmpty()) {
            throw new EntityNotFoundException("Customers empty");
        }

        stay.getCustomers().forEach(customer -> {
            if (customer.getId() == null || customer.getId() == 0
                    || !customerService.findById(customer.getId()).isPresent()) {
                customerService.save(customer);
            } else {
                stay.getCustomers().add(customer);
            }
        });

        // Set room by id
        Long roomId = stay.getRoom().getId();
        Room room = roomService.findById(roomId).orElseThrow(() -> new EntityNotFoundException("Room not found"));
        stay.setRoom(room);

        // Set room by id
        Long reasonId = stay.getReason().getId();
        Reason reason = reasonService.findById(reasonId)
                .orElseThrow(() -> new EntityNotFoundException("Reason not found"));
        stay.setReason(reason);

        // Set room by id
        Long roomPriceId = stay.getRoomPrice().getId();
        RoomPrice roomPrice = roomPriceService.findById(roomPriceId)
                .orElseThrow(() -> new EntityNotFoundException("Room price not found"));
        stay.setRoomPrice(roomPrice);

        return save(stay);

    }
}
