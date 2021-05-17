package com.sanger.sprintel.repository;

import com.sanger.sprintel.model.Image;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
