package com.sanger.sprintel.services;

import com.sanger.sprintel.dto.register.CloseRegisterDto;
import com.sanger.sprintel.error.exceptions.EntityNotFoundException;
import com.sanger.sprintel.error.exceptions.RegisterNotClosedException;
import com.sanger.sprintel.error.exceptions.RegisterNotOpenException;
import com.sanger.sprintel.model.Register;
import com.sanger.sprintel.model.UserEntity;
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

    public Register saveRegister(Register register, UserEntity user) {
        if (this.repository.findByActive(true).isPresent()) {
            throw new RegisterNotClosedException();
        } else {
            register.setUser(user);
            return repository.save(register);
        }
    }

    public Register closeRegister(CloseRegisterDto closeRegisterDto) {
        if (this.repository.findByActive(true).isPresent()) {
            Register registerUpdate = this.repository.findById(closeRegisterDto.getId())
                    .orElseThrow(() -> new EntityNotFoundException());
            registerUpdate.setCloseMount(closeRegisterDto.getCloseMount());
            registerUpdate.setActive(false);

            return repository.save(registerUpdate);
        } else {
            throw new RegisterNotOpenException();
        }
    }
}
