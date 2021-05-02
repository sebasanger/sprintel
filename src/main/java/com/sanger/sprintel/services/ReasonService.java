package com.sanger.sprintel.services;

import com.sanger.sprintel.model.Reason;
import com.sanger.sprintel.repository.ReasonRepository;
import com.sanger.sprintel.services.base.BaseService;

import org.springframework.stereotype.Service;

@Service
public class ReasonService extends BaseService<Reason, Long, ReasonRepository> {

}
