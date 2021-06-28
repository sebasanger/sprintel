package com.sanger.sprintel.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

import com.sanger.sprintel.model.Stay;
import com.sanger.sprintel.model.StayStatus;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StayRepository extends JpaRepository<Stay, Long> {
        Page<Stay> findByCreatedAt(Date date, Pageable pageable);

        Optional<Set<Stay>> findAllByEntryDateBetweenOrOutDateBetween(LocalDate start, LocalDate end, LocalDate start2,
                        LocalDate end2);

        Optional<Stay> findByEntryDateAfterAndOutDateBefore(LocalDate start, LocalDate end);

        Page<Stay> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end, Pageable pageable);

        Page<Stay> findByStatusAndEntryDateBetweenOrStatusAndOutDateBetween(StayStatus status, LocalDate start,
                        LocalDate end, StayStatus status2, LocalDate start2, LocalDate end2, Pageable pageable);

        Page<Stay> findByStatus(StayStatus status, Pageable pageable);

}
