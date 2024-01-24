package com.mydom.demo_wishlist.repository;

import com.mydom.demo_wishlist.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
