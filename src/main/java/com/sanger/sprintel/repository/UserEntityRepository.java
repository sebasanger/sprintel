package com.sanger.sprintel.repository;

import java.util.Optional;

import com.sanger.sprintel.model.UserEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findByUsername(String username);

	Optional<UserEntity> findByEmail(String email);

	Optional<UserEntity> findByEmailAndIdNot(String email, Long id);

	Page<UserEntity> findByUsernameIgnoreCaseContainingOrFullNameIgnoreCaseContaining(String username, String email,
			Pageable pageable);

}
