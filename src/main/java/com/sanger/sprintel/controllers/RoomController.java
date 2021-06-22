package com.sanger.sprintel.controllers;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import com.sanger.sprintel.dto.room.CheckRoomsAvailablesDto;
import com.sanger.sprintel.dto.user.ChangeImageResponseDto;
import com.sanger.sprintel.model.Room;
import com.sanger.sprintel.services.RoomService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController extends BaseController<Room, Long, RoomService> {

    private final RoomService roomService;

    @PutMapping(value = "/upload/image/{id}")
    public ResponseEntity<ChangeImageResponseDto> nuevoProducto(@RequestParam("file") MultipartFile file,
            @RequestParam("title") String title, @PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.CREATED).body(roomService.uploadAvatarAndDeleteOld(file, id, title));

    }

    @DeleteMapping(value = "/delete/image/{imageId}/room/{roomId}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long imageId, @PathVariable Long roomId) {

        roomService.deleteImage(roomId, imageId);

        return ResponseEntity.noContent().build();

    }

    @PostMapping("/abailability")
    public ResponseEntity<Set<Room>> roomsAbailability(
            @Valid @RequestBody CheckRoomsAvailablesDto checkRoomsAvailablesDto) {

        Set<Room> result = this.roomService.checkRoomsAvailability(checkRoomsAvailablesDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/status")
    public ResponseEntity<List<Room>> roomStatus() {

        List<Room> result = this.roomService.checkRoomsStatus();
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
