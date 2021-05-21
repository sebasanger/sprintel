package com.sanger.sprintel.services;

import com.sanger.sprintel.model.Register;
import com.sanger.sprintel.repository.RegisterRepository;
import com.sanger.sprintel.services.base.BaseService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RegisterService extends BaseService<Register, Long, RegisterRepository> {

    public Page<Register> filterAndPaginateRegister(String filter, Pageable pageable) {

        if (filter.length() == 0) {
            return this.repository.findAll(pageable);
        } else {
            Double balace = Double.parseDouble(filter);
            return this.repository.findByBalance(balace, pageable);
        }

    }
}
