package com.sanger.sprintel.services;

import com.sanger.sprintel.model.Register;
import com.sanger.sprintel.repository.RegisterRepository;
import com.sanger.sprintel.services.base.BaseService;

import org.springframework.stereotype.Service;

@Service
public class RegisterService extends BaseService<Register, Long, RegisterRepository> {

}
