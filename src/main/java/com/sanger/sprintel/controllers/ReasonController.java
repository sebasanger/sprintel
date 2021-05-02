package com.sanger.sprintel.controllers;

import com.sanger.sprintel.model.Reason;
import com.sanger.sprintel.services.ReasonService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/reason")
@RequiredArgsConstructor
public class ReasonController extends BaseController<Reason, Long, ReasonService> {

}
