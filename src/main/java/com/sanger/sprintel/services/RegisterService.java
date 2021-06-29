package com.sanger.sprintel.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.sanger.sprintel.dto.register.CloseRegisterDto;
import com.sanger.sprintel.error.exceptions.RegisterNotClosedException;
import com.sanger.sprintel.error.exceptions.RegisterNotOpenException;
import com.sanger.sprintel.model.Register;
import com.sanger.sprintel.model.UserEntity;
import com.sanger.sprintel.repository.RegisterRepository;
import com.sanger.sprintel.services.base.BaseService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterService extends BaseService<Register, Long, RegisterRepository> {

    public Page<Register> filterAndPaginateRegister(String filter, Pageable pageable, String start, String end) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        if (start.length() > 0 && end.length() > 0) {
            LocalDateTime startDate = LocalDateTime.parse(start, formatter);
            LocalDateTime endDate = LocalDateTime.parse(end, formatter);

            return this.repository.findByCreatedAtBetween(startDate, endDate, pageable);
        } else {
            return this.repository.findAll(pageable);
        }
    }

    public Register saveRegister(Register register, UserEntity user) {
        if (this.repository.findByActive(true).isPresent()) {
            throw new RegisterNotClosedException();
        } else {
            register.setUser(user);
            register.setActive(true);
            return repository.save(register);
        }
    }

    public Register closeRegister(CloseRegisterDto closeRegisterDto) {
        if (this.repository.findByActive(true).isPresent()) {
            Register registerUpdate = this.findActiveRegister();
            registerUpdate.setCloseMount(closeRegisterDto.getCloseMount());
            registerUpdate.setActive(false);
            registerUpdate.setCloseTime(LocalDateTime.now());

            return repository.save(registerUpdate);
        } else {
            throw new RegisterNotOpenException();
        }
    }

    public Register findActiveRegister() {
        if (this.repository.findByActive(true).isPresent()) {
            return this.repository.findByActive(true).get();
        } else {
            throw new RegisterNotOpenException();
        }
    }

    public Optional<Register> isRegisterActive() {
        return this.repository.findByActive(true);

    }

}
