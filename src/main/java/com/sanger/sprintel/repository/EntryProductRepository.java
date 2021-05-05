package com.sanger.sprintel.repository;

import java.util.Optional;
import java.util.Set;

import com.sanger.sprintel.model.EntryProduct;
import com.sanger.sprintel.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryProductRepository extends JpaRepository<EntryProduct, Long> {

    Optional<Set<EntryProduct>> findByProduct(Product product);

}
