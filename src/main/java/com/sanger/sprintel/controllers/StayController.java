package com.sanger.sprintel.controllers;

import java.util.Date;

import javax.validation.Valid;

import com.sanger.sprintel.dto.stay.CreateStayDto;
import com.sanger.sprintel.dto.stay.GetStayPaginatedDto;
import com.sanger.sprintel.dto.stay.StayDtoConverter;
import com.sanger.sprintel.error.exceptions.EntityNotFoundException;
import com.sanger.sprintel.model.Stay;
import com.sanger.sprintel.model.UserEntity;
import com.sanger.sprintel.services.StayService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/stay")
@RequiredArgsConstructor
public class StayController extends BaseController<Stay, Long, StayService> {

    private final StayService stayService;

    private final StayDtoConverter stayDtoConverter;

    @PostMapping("/save")
    public ResponseEntity<Stay> create(@Valid @RequestBody CreateStayDto newStay,
            @AuthenticationPrincipal UserEntity user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(stayService.saveStay(newStay, user));
    }

    @PostMapping("/paginate-filter")
    public ResponseEntity<?> paginateAndFilterPayments(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable,
            @RequestAttribute(required = false, name = "date") Date date) {

        Page<Stay> result = stayService.filterAndPaginateStays(date, pageable);

        if (result.isEmpty()) {
            throw new EntityNotFoundException();
        } else {
            Page<GetStayPaginatedDto> dtoList = result.map(stayDtoConverter::convertStayToStayPaginatedDto);

            return ResponseEntity.ok().body(dtoList);

        }
    }

}
