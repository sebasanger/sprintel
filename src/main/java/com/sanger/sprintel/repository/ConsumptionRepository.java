package com.sanger.sprintel.repository;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

import com.sanger.sprintel.model.Consumption;
import com.sanger.sprintel.model.Stay;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumptionRepository extends JpaRepository<Consumption, Long> {
    Page<Consumption> findByCreatedAt(Date date, Pageable pageable);

    Optional<Set<Consumption>> findByStay(Stay stay);
}
