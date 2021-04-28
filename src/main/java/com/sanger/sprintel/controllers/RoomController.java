package com.sanger.sprintel.controllers;

import java.util.List;

import com.sanger.sprintel.error.exceptions.UserNotFoundException;
import com.sanger.sprintel.model.Room;
import com.sanger.sprintel.services.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {

	private final RoomService roomService;

	@GetMapping("")
	public ResponseEntity<?> getUsers() {
		List<Room> result = roomService.findAll();

		if (result.isEmpty()) {
			throw new UserNotFoundException();
		} else {
			return ResponseEntity.ok().body(result);
		}
	}

}
