package com.sanger.sprintel.controllers;

import com.sanger.sprintel.model.Category;
import com.sanger.sprintel.services.CategoryService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController extends BaseController<Category, Long, CategoryService> {

}
