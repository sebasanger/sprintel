package com.sanger.sprintel.controllers;

import com.sanger.sprintel.error.exceptions.EntityNotFoundException;
import com.sanger.sprintel.model.Register;
import com.sanger.sprintel.services.RegisterService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController extends BaseController<Register, Long, RegisterService> {

    private final RegisterService registerService;

    @GetMapping("/paginate-filter")
    public ResponseEntity<?> paginateAndFilterCustomers(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.DESC) Pageable pageable,
            @RequestParam(defaultValue = "") String filter) {

        Page<Register> result = registerService.filterAndPaginateRegister(filter, pageable);

        if (result.isEmpty()) {
            throw new EntityNotFoundException();
        } else {
            return ResponseEntity.ok().body(result);
        }
    }
}
