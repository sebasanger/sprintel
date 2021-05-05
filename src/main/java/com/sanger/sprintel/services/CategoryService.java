package com.sanger.sprintel.services;

import com.sanger.sprintel.model.Category;
import com.sanger.sprintel.repository.CategoryRepository;
import com.sanger.sprintel.services.base.BaseService;

import org.springframework.stereotype.Service;

@Service
public class CategoryService extends BaseService<Category, Long, CategoryRepository> {

}
