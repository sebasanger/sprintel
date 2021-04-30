package com.sanger.sprintel.controllers;

import javax.validation.Valid;

import com.sanger.sprintel.model.Stay;
import com.sanger.sprintel.services.StayService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/stay")
@RequiredArgsConstructor
public class StayController extends BaseController<Stay, Long, StayService> {

    private final StayService stayService;

    @PostMapping("/save")
    public ResponseEntity<Stay> create(@Valid @RequestBody Stay newStay) {
        return ResponseEntity.status(HttpStatus.CREATED).body(stayService.saveStay(newStay));
    }

}
