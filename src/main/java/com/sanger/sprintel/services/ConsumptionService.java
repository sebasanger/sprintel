package com.sanger.sprintel.services;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

import com.sanger.sprintel.dto.consumption.CreateUpdateConsumptionDto;
import com.sanger.sprintel.error.exceptions.EntityNotFoundException;
import com.sanger.sprintel.model.Consumption;
import com.sanger.sprintel.model.Product;
import com.sanger.sprintel.model.Register;
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
    private final RegisterService registerService;

    public Optional<Set<Consumption>> findByStay(Long stayId) {
        Stay stay = stayService.findById(stayId).orElseThrow(() -> new EntityNotFoundException());
        return this.repository.findByStay(stay);
    }

    public Consumption saveUpdateConsumption(CreateUpdateConsumptionDto createUpdateConsumptionDto, UserEntity user) {
        Consumption consumption = new Consumption();

        consumption.setUser(user);
        consumption.setAmount(createUpdateConsumptionDto.getAmount());

        // Set product by id
        Product product = productService.findById(createUpdateConsumptionDto.getProductId())
                .orElseThrow(() -> new EntityNotFoundException("Product method not found"));
        consumption.setProduct(product);

        // set actual product price in the consumption
        consumption.setPrice(product.getPrice());

        // Set stay by id
        Stay stay = stayService.findById(createUpdateConsumptionDto.getStayId())
                .orElseThrow(() -> new EntityNotFoundException("Stay not found"));
        consumption.setStay(stay);

        // IF PAID EXISTS
        if (createUpdateConsumptionDto.getPaid() != null && createUpdateConsumptionDto.getPaymentMethodId() != null) {
            // Set register
            Register register = registerService.findActiveRegister();
            consumption.setRegister(register);

        }

        return save(consumption);

    }

    public Page<Consumption> filterAndPaginateConsumptions(Date date, Pageable pageable) {
        if (date == null) {
            return this.repository.findAll(pageable);
        } else {
            return this.repository.findByCreatedAt(date, pageable);
        }
    }
}
