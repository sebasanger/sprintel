package com.sanger.sprintel.controllers;

import com.sanger.sprintel.model.Register;
import com.sanger.sprintel.services.RegisterService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController extends BaseController<Register, Long, RegisterService> {

}
