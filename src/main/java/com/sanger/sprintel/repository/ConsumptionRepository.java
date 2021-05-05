package com.sanger.sprintel.repository;

import java.util.Optional;
import java.util.Set;

import com.sanger.sprintel.model.Consumption;
import com.sanger.sprintel.model.Stay;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumptionRepository extends JpaRepository<Consumption, Long> {
    Optional<Set<Consumption>> findByStay(Stay stay);
}
