package com.mydom.demo_wishlist.repository;

import com.mydom.demo_wishlist.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WishlistRepository extends JpaRepository<Wishlist,Long> {
    Optional<Wishlist> findByCustomerId(Long customerId);
}
