package com.sanger.sprintel.services;

import java.util.Optional;
import java.util.Set;

import com.sanger.sprintel.error.exceptions.EntityNotFoundException;
import com.sanger.sprintel.model.EntryProduct;
import com.sanger.sprintel.model.Product;
import com.sanger.sprintel.model.UserEntity;
import com.sanger.sprintel.repository.EntryProductRepository;
import com.sanger.sprintel.services.base.BaseService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EntryProductService extends BaseService<EntryProduct, Long, EntryProductRepository> {
    private final UserEntityService userEntityService;
    private final ProductService productService;

    public EntryProduct saveEntryProduct(EntryProduct entryProduct) {

        // Set user by id
        Long userId = entryProduct.getUser().getId();
        UserEntity user = userEntityService.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        entryProduct.setUser(user);

        // Set product by id
        Long productId = entryProduct.getProduct().getId();
        Product product = productService.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
        entryProduct.setProduct(product);

        return save(entryProduct);

    }

    public Optional<Set<EntryProduct>> findByProduct(Long productId) {
        Product product = productService.findById(productId).orElseThrow(() -> new EntityNotFoundException());
        return this.repository.findByProduct(product);
    }
}
