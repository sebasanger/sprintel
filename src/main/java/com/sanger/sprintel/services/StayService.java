package com.sanger.sprintel.services;

import com.sanger.sprintel.model.Stay;
import com.sanger.sprintel.repository.StayRepository;
import com.sanger.sprintel.services.base.BaseService;

import org.springframework.stereotype.Service;

@Service
public class StayService extends BaseService<Stay, Long, StayRepository> {

}
