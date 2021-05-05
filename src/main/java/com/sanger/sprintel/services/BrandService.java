package com.sanger.sprintel.services;

import com.sanger.sprintel.model.Brand;
import com.sanger.sprintel.repository.BrandRepository;
import com.sanger.sprintel.services.base.BaseService;

import org.springframework.stereotype.Service;

@Service
public class BrandService extends BaseService<Brand, Long, BrandRepository> {

}
