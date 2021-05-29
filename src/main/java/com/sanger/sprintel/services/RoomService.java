package com.sanger.sprintel.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sanger.sprintel.controllers.FilesController;
import com.sanger.sprintel.dto.room.CheckRoomsAvailablesDto;
import com.sanger.sprintel.dto.user.ChangeImageResponseDto;
import com.sanger.sprintel.error.exceptions.EntityNotFoundException;
import com.sanger.sprintel.model.Image;
import com.sanger.sprintel.model.Room;
import com.sanger.sprintel.model.Stay;
import com.sanger.sprintel.repository.RoomRepository;
import com.sanger.sprintel.repository.StayRepository;
import com.sanger.sprintel.services.base.BaseService;
import com.sanger.sprintel.utils.upload.StorageException;
import com.sanger.sprintel.utils.upload.StorageService;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomService extends BaseService<Room, Long, RoomRepository> {

    private static final List<String> contentTypes = Arrays.asList("image/png", "image/jpeg", "image/gif");

    private final StorageService storageService;

    private final ImageService imageService;

    private final StayRepository stayRepository;

    public ChangeImageResponseDto uploadAvatarAndDeleteOld(MultipartFile file, Long id, String title) {
        System.out.println(file.getContentType());
        if (file.isEmpty()) {
            throw new StorageException("Image not found");
        }
        String fileContentType = file.getContentType();
        if (!contentTypes.contains(fileContentType)) {
            throw new StorageException("Image type error");
        }

        String image = storageService.store(file);
        String urlImage = MvcUriComponentsBuilder.fromMethodName(FilesController.class, "serveFile", image, null)
                .build().toUriString();

        Room room = this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        Set<Image> images;
        if (room.getImages() == null) {
            images = new HashSet<>();
        } else {
            images = room.getImages();
        }

        images.add(new Image(urlImage, title));

        room.setImages(images);

        this.save(room);

        return new ChangeImageResponseDto(room.getId(), urlImage);

    }

    public void deleteImage(Long roomId, Long imageId) {
        Image image = imageService.findById(imageId).orElseThrow(() -> new EntityNotFoundException("Image not found"));

        Room room = this.repository.findById(roomId).orElseThrow(() -> new EntityNotFoundException("Room not found"));

        storageService.delete(image.getPath());

        Set<Image> images = room.getImages();

        images.remove(image);

        this.save(room);

        this.imageService.delete(image);

    }

    public Set<Room> checkRoomsAvailability(CheckRoomsAvailablesDto checkRoomsAvailablesDto) {

        Set<Stay> ocuppedRooms = stayRepository.findAllByEntryDateBetweenOrOutDateBetween(
                checkRoomsAvailablesDto.getStart(), checkRoomsAvailablesDto.getEnd(),
                checkRoomsAvailablesDto.getStart(), checkRoomsAvailablesDto.getEnd()).get();
        Set<Long> idRooms = new HashSet<>();

        ocuppedRooms.forEach(ocuppedRoom -> {
            if (ocuppedRoom.getRoom().getCapacity() >= checkRoomsAvailablesDto.getCapacity()) {
                idRooms.add(ocuppedRoom.getRoom().getId());
            }
        });

        if (idRooms.size() == 0) {
            return this.repository.findByCapacityGreaterThanEqual(checkRoomsAvailablesDto.getCapacity()).get();
        } else {
            return this.repository
                    .findByCapacityGreaterThanEqualAndIdNotIn(checkRoomsAvailablesDto.getCapacity(), idRooms).get();
        }

    }

}
