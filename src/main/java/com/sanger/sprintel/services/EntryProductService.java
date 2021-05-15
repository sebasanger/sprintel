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
    private final ProductService productService;

    public EntryProduct saveEntryProduct(EntryProduct entryProduct, UserEntity user) {

        entryProduct.setUser(user);

        Product product = this.findProductOrThrowError(entryProduct.getProduct().getId());

        product.addStock(entryProduct.getAmount());

        return save(entryProduct);

    }

    public Optional<Set<EntryProduct>> findByProduct(Long productId) {
        Product product = this.findProductOrThrowError(productId);
        return this.repository.findByProduct(product);
    }

    public EntryProduct update(EntryProduct entryProduct, UserEntity user) {
        if (entryProduct.getAmount() != null) {
            EntryProduct oldEntryProduct = this.findById(entryProduct.getId())
                    .orElseThrow(() -> new EntityNotFoundException());

            Product product = this.findProductOrThrowError(entryProduct.getProduct().getId());

            product.updateStock((short) (entryProduct.getAmount() - oldEntryProduct.getAmount()));

        }
        entryProduct.setUser(user);

        return repository.save(entryProduct);
    }

    public void delete(EntryProduct entryProduct) {

        Product product = this.findProductOrThrowError(entryProduct.getProduct().getId());
        product.removeStock(entryProduct.getAmount());

        repository.delete(entryProduct);
    }

    private Product findProductOrThrowError(Long productId) {
        Product product = productService.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
        return product;
    }
}
