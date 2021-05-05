package com.sanger.sprintel.repository;

import com.sanger.sprintel.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
