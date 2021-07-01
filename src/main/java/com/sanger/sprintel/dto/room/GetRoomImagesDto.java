package com.sanger.sprintel.dto.room;

import java.util.Set;

import com.sanger.sprintel.model.Image;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class GetRoomImagesDto {

    private String number;

    private Set<Image> images;

}
