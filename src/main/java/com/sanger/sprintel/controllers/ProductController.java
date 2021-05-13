package com.sanger.sprintel.controllers;

import javax.validation.Valid;

import com.sanger.sprintel.model.Product;
import com.sanger.sprintel.services.ProductService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController extends BaseController<Product, Long, ProductService> {
    private final ProductService productService;

    @PostMapping("/")
    public ResponseEntity<Product> create(@Valid @RequestBody Product newProduct) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(newProduct));
    }
}
