package com.sanger.sprintel.controllers;

import java.util.List;

import com.sanger.sprintel.error.exceptions.EntityNotFoundException;
import com.sanger.sprintel.services.base.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public abstract class BaseController<M, ID, S extends BaseService<M, ID, ?>> {

	@Autowired
	protected S service;

	@GetMapping("")
	public ResponseEntity<?> getUsers() {
		List<M> result = service.findAll();

		if (result.isEmpty()) {
			throw new EntityNotFoundException();
		} else {
			return ResponseEntity.ok().body(result);
		}
	}

	@GetMapping("/pageable")
	public ResponseEntity<?> paginatedList(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable) {

		Page<M> result = service.findAll(pageable);

		if (result.isEmpty()) {
			throw new EntityNotFoundException();
		} else {
			return ResponseEntity.ok().body(result);
		}
	}

}
