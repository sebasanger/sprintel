package com.sanger.sprintel.services;

import com.sanger.sprintel.error.exceptions.EntityNotFoundException;
import com.sanger.sprintel.model.Room;
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

        return save(stay);

    }
}
