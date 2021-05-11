package com.sanger.sprintel.controllers;

import com.sanger.sprintel.model.RoomPrice;
import com.sanger.sprintel.services.RoomPriceService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/roomprice")
@RequiredArgsConstructor
public class RoomPriceController extends BaseController<RoomPrice, Long, RoomPriceService> {

}
