package com.sanger.sprintel.controllers;

import com.sanger.sprintel.model.Room;
import com.sanger.sprintel.services.RoomService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController extends BaseController<Room, Long, RoomService> {

}
