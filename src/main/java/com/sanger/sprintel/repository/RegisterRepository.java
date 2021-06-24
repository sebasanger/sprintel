package com.sanger.sprintel.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import com.sanger.sprintel.model.Register;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<Register, Long> {
    Page<Register> findByActualBalance(Double balance, Pageable pageable);

    Optional<Register> findByActive(Boolean bool);

    Page<Register> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end, Pageable pageable);
}
