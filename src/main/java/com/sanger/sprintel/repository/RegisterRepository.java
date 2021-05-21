package com.sanger.sprintel.repository;

import com.sanger.sprintel.model.Register;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<Register, Long> {
    Page<Register> findByBalance(Double balance, Pageable pageable);
}
