package com.mydom.demo_wishlist.controller;

import com.mydom.demo_wishlist.service.ProductService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


}
