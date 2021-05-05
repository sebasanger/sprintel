package com.sanger.sprintel.services;

import com.sanger.sprintel.error.exceptions.EntityNotFoundException;
import com.sanger.sprintel.model.Brand;
import com.sanger.sprintel.model.Category;
import com.sanger.sprintel.model.Product;
import com.sanger.sprintel.repository.ProductRepository;
import com.sanger.sprintel.services.base.BaseService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService extends BaseService<Product, Long, ProductRepository> {
    private final CategoryService categoryService;
    private final BrandService brandService;

    public Product saveProduct(Product product) {

        // Set brand by id
        Long brandId = product.getBrand().getId();
        Brand brand = brandService.findById(brandId).orElseThrow(() -> new EntityNotFoundException("Brand not found"));
        product.setBrand(brand);

        // Set category by id
        Long categoryId = product.getBrand().getId();
        Category category = categoryService.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
        product.setCategory(category);

        return save(product);

    }

}
