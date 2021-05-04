package com.sanger.sprintel.services;

import com.sanger.sprintel.model.InvoiceType;
import com.sanger.sprintel.repository.InvoiceTypeReposirtory;
import com.sanger.sprintel.services.base.BaseService;

import org.springframework.stereotype.Service;

@Service
public class InvoiceTypeService extends BaseService<InvoiceType, Long, InvoiceTypeReposirtory> {

}
