package com.sanger.sprintel.controllers;

import com.sanger.sprintel.model.InvoiceType;
import com.sanger.sprintel.services.InvoiceTypeService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/invoice")
@RequiredArgsConstructor
public class InvoiceTypeController extends BaseController<InvoiceType, Long, InvoiceTypeService> {

}
