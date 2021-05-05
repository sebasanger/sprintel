package com.sanger.sprintel.controllers;

import com.sanger.sprintel.model.Brand;
import com.sanger.sprintel.services.BrandService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor
public class BrandController extends BaseController<Brand, Long, BrandService> {

}
