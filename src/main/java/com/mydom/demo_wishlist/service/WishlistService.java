package com.mydom.demo_wishlist.service;

import com.mydom.demo_wishlist.exception.ResourceNotFoundException;
import com.mydom.demo_wishlist.model.Product;
import com.mydom.demo_wishlist.model.Wishlist;
import com.mydom.demo_wishlist.repository.WishlistRepository;

import java.util.Optional;
import java.util.Set;

public class WishlistService {
    private WishlistRepository wishlistRepository;

    public WishlistService(WishlistRepository repository) {
        this.wishlistRepository = repository;
    }
    public Wishlist create(Wishlist wishlist) {
        return this.wishlistRepository.save(wishlist);
    }

    public Optional<Wishlist> findByCustomerId(Long customerId) {
        return this.wishlistRepository.findByCustomerId(customerId);
    }

    public Wishlist addProduct(Set<Product> newProducts, Long id) throws ResourceNotFoundException {
        Wishlist wishlist = this.wishlistRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(""));
        wishlist.getProducts().addAll(newProducts);
        return wishlist;
    }

    public void delete(Long id) {
        Wishlist wishlist = this.wishlistRepository.getOne(id);
        this.wishlistRepository.delete(wishlist);
    }

}
