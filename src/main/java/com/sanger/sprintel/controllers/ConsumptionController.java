package com.sanger.sprintel.controllers;

import java.util.Set;

import javax.validation.Valid;

import com.sanger.sprintel.error.exceptions.EntityNotFoundException;
import com.sanger.sprintel.model.Consumption;
import com.sanger.sprintel.services.ConsumptionService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/consumption")
@RequiredArgsConstructor
public class ConsumptionController extends BaseController<Consumption, Long, ConsumptionService> {

    private final ConsumptionService consumptionService;

    @PostMapping("/save")
    public ResponseEntity<Consumption> create(@Valid @RequestBody Consumption newConsumption) {
        return ResponseEntity.status(HttpStatus.CREATED).body(consumptionService.saveConsumption(newConsumption));
    }

    @GetMapping("/findByStay/{id}")
    public ResponseEntity<?> findByEntityId(@PathVariable Long id) {
        Set<Consumption> result = service.findByStay(id).orElseThrow(() -> new EntityNotFoundException());
        return ResponseEntity.ok().body(result);
    }
}
