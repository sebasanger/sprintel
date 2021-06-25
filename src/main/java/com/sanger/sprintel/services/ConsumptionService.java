package com.sanger.sprintel.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Set;

import com.sanger.sprintel.dto.consumption.CreateConsumptionDto;
import com.sanger.sprintel.dto.payment.CreatePaymentDto;
import com.sanger.sprintel.error.exceptions.EntityNotFoundException;
import com.sanger.sprintel.model.Consumption;
import com.sanger.sprintel.model.Product;
import com.sanger.sprintel.model.Stay;
import com.sanger.sprintel.model.UserEntity;
import com.sanger.sprintel.repository.ConsumptionRepository;
import com.sanger.sprintel.services.base.BaseService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConsumptionService extends BaseService<Consumption, Long, ConsumptionRepository> {

    private final StayService stayService;
    private final ProductService productService;

    private final PaymentService paymentService;

    public Optional<Set<Consumption>> findByStay(Long stayId) {
        Stay stay = stayService.findById(stayId).orElseThrow(() -> new EntityNotFoundException());
        return this.repository.findByStay(stay);
    }

    public Consumption saveConsumption(CreateConsumptionDto createConsumptionDto, UserEntity user) {
        Consumption consumption = new Consumption();

        // Set product by id
        Product product = productService.findById(createConsumptionDto.getProductId())
                .orElseThrow(() -> new EntityNotFoundException("Product method not found"));
        consumption.setProduct(product);
        // reduct stock of product
        product.removeStock(createConsumptionDto.getAmount());

        // Set stay by id
        Stay stay = stayService.findById(createConsumptionDto.getStayId())
                .orElseThrow(() -> new EntityNotFoundException("Stay not found"));
        consumption.setStay(stay);

        // set actual product price in the consumption
        consumption.setPrice(product.getPrice());
        consumption.setUser(user);
        consumption.setAmount(createConsumptionDto.getAmount());
        consumption.setPaid(createConsumptionDto.getPaid());

        // IF PAID EXISTS
        if (createConsumptionDto.getPaid() != null && createConsumptionDto.getPaymentMethodId() != null) {

            CreatePaymentDto createPaymentDto = new CreatePaymentDto();
            createPaymentDto.setAmount(createConsumptionDto.getPaid());
            createPaymentDto.setPaymentMethodId(createConsumptionDto.getPaymentMethodId());
            createPaymentDto.setStayId(createConsumptionDto.getStayId());
            createPaymentDto.setDescription("Pay for " + product.getName());

            this.paymentService.savePayment(createPaymentDto, user);
        }

        return save(consumption);

    }

    public Page<Consumption> filterAndPaginateConsumptions(String start, String end, Pageable pageable) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        if (start.length() > 0 && end.length() > 0) {
            LocalDateTime startDate = LocalDateTime.parse(start, formatter);
            LocalDateTime endDate = LocalDateTime.parse(end, formatter);

            return this.repository.findByCreatedAtBetween(startDate, endDate, pageable);
        } else {
            return this.repository.findAll(pageable);
        }
    }

}
