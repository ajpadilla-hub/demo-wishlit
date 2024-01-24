package com.mydom.demo_wishlist.service;

import com.mydom.demo_wishlist.exception.ResourceNotFoundException;
import com.mydom.demo_wishlist.model.Product;
import com.mydom.demo_wishlist.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product) {
        return this.productRepository.save(product);
    }

    public Optional<Product> findById(Long id) {
        return this.productRepository.findById(id);
    }

    public List<Product> getAll() {
        return new ArrayList<>(productRepository.findAll());

    }

    public Product update(Product newProduct, Long id) throws ResourceNotFoundException {
        Optional<Product> optionalProduct = this.findById(id);
        Product product = optionalProduct.orElseThrow(() -> new ResourceNotFoundException(""));
        product.setTitle(newProduct.getTitle());
        product.setPrice(newProduct.getPrice());
        return product;
    }

    @Transactional
    public void delete(Long id) throws ResourceNotFoundException {
        Optional<Product> optionalProduct = this.findById(id);
        Product product = optionalProduct.orElseThrow(() -> new ResourceNotFoundException(""));
        this.productRepository.delete(product);
    }
}
