package com.sanger.sprintel.controllers;

import java.util.Set;

import javax.validation.Valid;

import com.sanger.sprintel.error.exceptions.EntityNotFoundException;
import com.sanger.sprintel.model.EntryProduct;
import com.sanger.sprintel.model.UserEntity;
import com.sanger.sprintel.services.EntryProductService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/entryproduct")
@RequiredArgsConstructor
public class EntryProductController {

    private final EntryProductService entryProductService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        List<EntryProduct> result = entryProductService.findAll();

        if (result.isEmpty()) {
            throw new EntityNotFoundException();
        } else {
            return ResponseEntity.ok().body(result);
        }
    }

    @PostMapping("/")
    public ResponseEntity<EntryProduct> create(@Valid @RequestBody EntryProduct newEntryProduct,
            @AuthenticationPrincipal UserEntity user) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(entryProductService.saveEntryProduct(newEntryProduct, user));
    }

    @GetMapping("/findByProduct/{id}")
    public ResponseEntity<?> findByProductId(@PathVariable Long id) {
        Set<EntryProduct> result = entryProductService.findByProduct(id)
                .orElseThrow(() -> new EntityNotFoundException());
        return ResponseEntity.ok().body(result);
    }

    @PutMapping({ "", "/{id}" })
    public ResponseEntity<EntryProduct> update(@Valid @RequestBody EntryProduct entity,
            @PathVariable(required = false) Long id, @AuthenticationPrincipal UserEntity user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(entryProductService.update(entity, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        EntryProduct entity = entryProductService.findById(id).orElseThrow(() -> new EntityNotFoundException());
        entryProductService.delete(entity);
        return ResponseEntity.noContent().build();
    }
}
