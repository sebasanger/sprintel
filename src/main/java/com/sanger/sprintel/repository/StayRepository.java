package com.sanger.sprintel.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

import com.sanger.sprintel.model.Stay;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StayRepository extends JpaRepository<Stay, Long> {
    Page<Stay> findByCreatedAt(Date date, Pageable pageable);

    Optional<Set<Stay>> findAllByEntryDateBetweenOrOutDateBetween(LocalDate start, LocalDate end, LocalDate start2,
            LocalDate end2);

    Optional<Stay> findByEntryDateAfterAndOutDateBefore(LocalDate start, LocalDate end);
}
