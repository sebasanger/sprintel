package com.sanger.sprintel.repository;

import java.util.Optional;
import java.util.Set;

import com.sanger.sprintel.model.Room;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {

    Optional<Set<Room>> findByIdNotInAndCapacityGreaterThanEqual(Set<Long> ids, Short capacity);
}
