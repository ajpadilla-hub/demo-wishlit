package com.mydom.demo_wishlist.controller;

import com.mydom.demo_wishlist.service.WishlistService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WishlistController {
private WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }


}
