package com.sanger.sprintel.services;

import java.util.Arrays;
import java.util.List;

import com.sanger.sprintel.controllers.FilesController;
import com.sanger.sprintel.dto.user.ChangeImageResponseDto;
import com.sanger.sprintel.error.exceptions.EntityNotFoundException;
import com.sanger.sprintel.model.Room;
import com.sanger.sprintel.repository.RoomRepository;
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

    public ChangeImageResponseDto uploadAvatarAndDeleteOld(MultipartFile file, Long id) {
        System.out.println(file.getContentType());
        if (file.isEmpty()) {
            throw new StorageException("Image not found");
        }
        String fileContentType = file.getContentType();
        if (!contentTypes.contains(fileContentType)) {
            throw new StorageException("Image type error");
        }

        String urlImage = null;

        String image = storageService.store(file);
        urlImage = MvcUriComponentsBuilder.fromMethodName(FilesController.class, "serveFile", image, null).build()
                .toUriString();

        Room room = this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException());

        // this.deleteRoomImageIfExist(room);

        // room.setImage(urlImage);

        this.save(room);

        return new ChangeImageResponseDto(room.getId(), urlImage);

    }

}
