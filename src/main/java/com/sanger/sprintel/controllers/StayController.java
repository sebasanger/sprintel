package com.sanger.sprintel.controllers;

import com.sanger.sprintel.model.Stay;
import com.sanger.sprintel.services.StayService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/stay")
@RequiredArgsConstructor
public class StayController extends BaseController<Stay, Long, StayService> {

}
