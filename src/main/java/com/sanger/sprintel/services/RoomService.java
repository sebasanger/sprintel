package com.sanger.sprintel.services;

import com.sanger.sprintel.model.Room;
import com.sanger.sprintel.repository.RoomRepository;
import com.sanger.sprintel.services.base.BaseService;

import org.springframework.stereotype.Service;

@Service
public class RoomService extends BaseService<Room, Long, RoomRepository> {

}
