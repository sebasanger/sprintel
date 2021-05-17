package com.sanger.sprintel.services;

import com.sanger.sprintel.model.Image;
import com.sanger.sprintel.repository.ImageRepository;
import com.sanger.sprintel.services.base.BaseService;

import org.springframework.stereotype.Service;

@Service
public class ImageService extends BaseService<Image, Long, ImageRepository> {

}
