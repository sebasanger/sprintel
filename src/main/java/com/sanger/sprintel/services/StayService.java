package com.sanger.sprintel.services;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.sanger.sprintel.dto.stay.CreateStayDto;
import com.sanger.sprintel.error.exceptions.EntityNotFoundException;
import com.sanger.sprintel.model.Payment;
import com.sanger.sprintel.model.PaymentMethod;
import com.sanger.sprintel.model.Reason;

import com.sanger.sprintel.model.Room;
import com.sanger.sprintel.model.RoomPrice;
import com.sanger.sprintel.model.Stay;
import com.sanger.sprintel.model.UserEntity;
import com.sanger.sprintel.repository.StayRepository;
import com.sanger.sprintel.services.base.BaseService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StayService extends BaseService<Stay, Long, StayRepository> {

    private final CustomerService customerService;
    private final RoomService roomService;
    private final ReasonService reasonService;
    private final RoomPriceService roomPriceService;
    private final PaymentMethodService paymentMethodService;
    private final RegisterService registerService;

    public Stay saveStay(CreateStayDto createStayDto, UserEntity user) {
        Stay stay = new Stay();
        stay.setId(null);

        // add the customers in the stay
        if (createStayDto.getCustomers().isEmpty()) {
            throw new EntityNotFoundException("Customers could not be empty");
        }

        createStayDto.getCustomers().forEach(customer -> {
            if (customer.getId() == null || customer.getId() == 0
                    || !customerService.findById(customer.getId()).isPresent()) {
                customerService.save(customer);
            } else {
                createStayDto.getCustomers().add(customer);
            }
        });

        // Set room by id
        Room room = roomService.findById(createStayDto.getRoomId())
                .orElseThrow(() -> new EntityNotFoundException("Room not found"));
        stay.setRoom(room);

        // Set room by id
        Reason reason = reasonService.findById(createStayDto.getReasonId())
                .orElseThrow(() -> new EntityNotFoundException("Reason not found"));
        stay.setReason(reason);

        // Set room by id
        RoomPrice roomPrice = roomPriceService.findById(createStayDto.getRoomPriceId())
                .orElseThrow(() -> new EntityNotFoundException("Room price not found"));
        stay.setRoomPrice(roomPrice);

        // add pay if the createStayDto is paid
        if (createStayDto.getPaid() != null && createStayDto.getPaid() != 0) {
            Set<Payment> payments = new HashSet<>();
            Payment payment = new Payment();
            payment.setAmount(createStayDto.getPaid());

            // Set apyment method
            PaymentMethod paymentMethod = paymentMethodService.findById(createStayDto.getPaymentMethodId())
                    .orElseThrow(() -> new EntityNotFoundException("Payment method not found"));
            payment.setPaymentMethod(paymentMethod);
            // Set register
            payment.setRegister(registerService.findActiveRegister());

            payment.setUser(user);

            payment.setStay(stay);

            payments.add(payment);

            stay.setPayments(payments);
        }

        stay.setActive(createStayDto.isActive());
        stay.setPricePerDay(roomPrice.getPrice());
        stay.setEntryDate(createStayDto.getEntryDate());
        stay.setOutDate(createStayDto.getOutDate());
        stay.setTotalGuest(createStayDto.getTotalGuest());
        stay.setPaid(createStayDto.getPaid());

        stay.setTotalToPay(createStayDto.getPaid());

        return save(stay);

    }

    public Page<Stay> filterAndPaginateStays(Date date, Pageable pageable) {
        if (date == null) {
            return this.repository.findAll(pageable);
        } else {
            return this.repository.findByCreatedAt(date, pageable);
        }
    }
}
