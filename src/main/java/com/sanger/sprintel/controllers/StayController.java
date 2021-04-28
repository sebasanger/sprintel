package com.sanger.sprintel.controllers;

import java.util.List;

import com.sanger.sprintel.error.exceptions.UserNotFoundException;
import com.sanger.sprintel.model.Stay;
import com.sanger.sprintel.services.StayService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/stay")
@RequiredArgsConstructor
public class StayController {

	private final StayService stayService;

	@GetMapping("")
	public ResponseEntity<?> getUsers() {
		List<Stay> result = stayService.findAll();

		if (result.isEmpty()) {
			throw new UserNotFoundException();
		} else {
			return ResponseEntity.ok().body(result);
		}
	}

}
