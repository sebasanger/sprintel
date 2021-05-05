package com.sanger.sprintel.controllers;

import java.util.Set;

import javax.validation.Valid;

import com.sanger.sprintel.error.exceptions.EntityNotFoundException;
import com.sanger.sprintel.model.EntryProduct;
import com.sanger.sprintel.services.EntryProductService;

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
@RequestMapping("/entry-product")
@RequiredArgsConstructor
public class EntryProductController extends BaseController<EntryProduct, Long, EntryProductService> {

    private final EntryProductService entryProductService;

    @PostMapping("/save")
    public ResponseEntity<EntryProduct> create(@Valid @RequestBody EntryProduct newEntryProduct) {
        return ResponseEntity.status(HttpStatus.CREATED).body(entryProductService.saveEntryProduct(newEntryProduct));
    }

    @GetMapping("/findByProduct/{id}")
    public ResponseEntity<?> findByProductId(@PathVariable Long id) {
        Set<EntryProduct> result = service.findByProduct(id).orElseThrow(() -> new EntityNotFoundException());
        return ResponseEntity.ok().body(result);
    }
}
