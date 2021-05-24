package com.sanger.sprintel.repository;

import java.util.Date;

import com.sanger.sprintel.model.Stay;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StayRepository extends JpaRepository<Stay, Long> {
    Page<Stay> findByCreatedAt(Date date, Pageable pageable);
}
