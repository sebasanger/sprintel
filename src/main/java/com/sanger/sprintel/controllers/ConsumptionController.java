package com.sanger.sprintel.controllers;

import java.util.Date;
import java.util.Set;

import javax.validation.Valid;

import com.sanger.sprintel.dto.consumption.ConsumptionDtoConverter;
import com.sanger.sprintel.dto.consumption.CreateConsumptionDto;
import com.sanger.sprintel.dto.consumption.GetConsumptionPaginatedDto;
import com.sanger.sprintel.error.exceptions.EntityNotFoundException;
import com.sanger.sprintel.model.Consumption;
import com.sanger.sprintel.model.UserEntity;
import com.sanger.sprintel.services.ConsumptionService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/consumption")
@RequiredArgsConstructor
public class ConsumptionController extends BaseController<Consumption, Long, ConsumptionService> {

    private final ConsumptionService consumptionService;

    private final ConsumptionDtoConverter consumptionDtoConverter;

    @PostMapping("/save")
    public ResponseEntity<?> create(@Valid @RequestBody CreateConsumptionDto newConsumption,
            @AuthenticationPrincipal UserEntity user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(consumptionService.saveConsumption(newConsumption, user));
    }

    @GetMapping("/findByStay/{id}")
    public ResponseEntity<?> findByEntityId(@PathVariable Long id) {
        Set<Consumption> result = service.findByStay(id).orElseThrow(() -> new EntityNotFoundException());
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/paginate-filter")
    public ResponseEntity<?> paginateAndFilterPayments(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.DESC) Pageable pageable,
            @RequestAttribute(required = false, name = "date") Date date) {

        Page<Consumption> result = consumptionService.filterAndPaginateConsumptions(date, pageable);

        if (result.isEmpty()) {
            throw new EntityNotFoundException();
        } else {
            Page<GetConsumptionPaginatedDto> dtoList = result
                    .map(consumptionDtoConverter::convertConsumptionToConsumptionPaginateDto);

            return ResponseEntity.ok().body(dtoList);

        }
    }

}
