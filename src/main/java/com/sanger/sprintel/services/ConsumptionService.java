package com.sanger.sprintel.services;

import java.util.Optional;
import java.util.Set;

import com.sanger.sprintel.error.exceptions.EntityNotFoundException;
import com.sanger.sprintel.model.Consumption;
import com.sanger.sprintel.model.Product;
import com.sanger.sprintel.model.Register;
import com.sanger.sprintel.model.Stay;
import com.sanger.sprintel.model.UserEntity;
import com.sanger.sprintel.repository.ConsumptionRepository;
import com.sanger.sprintel.services.base.BaseService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConsumptionService extends BaseService<Consumption, Long, ConsumptionRepository> {

    private final StayService stayService;
    private final UserEntityService userEntityService;
    private final ProductService paymentMethodService;
    private final RegisterService registerService;

    public Optional<Set<Consumption>> findByStay(Long stayId) {
        Stay stay = stayService.findById(stayId).orElseThrow(() -> new EntityNotFoundException());
        return this.repository.findByStay(stay);
    }

    public Consumption saveConsumption(Consumption consumption) {

        // Set user by id
        Long userId = consumption.getUser().getId();
        UserEntity user = userEntityService.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        consumption.setUser(user);

        // Set register by id
        Long registerId = consumption.getRegister().getId();
        Register register = registerService.findById(registerId)
                .orElseThrow(() -> new EntityNotFoundException("Register not found"));
        consumption.setRegister(register);

        // Set stay by id
        Long stayId = consumption.getStay().getId();
        Stay stay = stayService.findById(stayId).orElseThrow(() -> new EntityNotFoundException("Stay not found"));
        consumption.setStay(stay);

        // Set product by id
        Long productId = consumption.getProduct().getId();
        Product product = paymentMethodService.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product method not found"));
        consumption.setProduct(product);

        // set actual product price in the consumption
        consumption.setPrice(product.getPrice());

        return save(consumption);

    }
}
