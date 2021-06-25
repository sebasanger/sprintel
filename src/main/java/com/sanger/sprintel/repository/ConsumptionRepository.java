package com.sanger.sprintel.repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

import com.sanger.sprintel.model.Consumption;
import com.sanger.sprintel.model.Stay;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumptionRepository extends JpaRepository<Consumption, Long> {

    Page<Consumption> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end, Pageable pageable);

    Optional<Set<Consumption>> findByStay(Stay stay);
}
