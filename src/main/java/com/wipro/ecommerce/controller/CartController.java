package com.wipro.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.ecommerce.entity.Cart;
import com.wipro.ecommerce.service.CartService;

@RestController
@RequestMapping("/ecommerce/cart")
public class CartController {

    @Autowired
    CartService service;

    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestBody Cart cart) {
        return ResponseEntity.ok(service.addToCart(cart));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Cart>> getAllCartItem() {
        return ResponseEntity.ok(service.getAllCartItem());
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCart(@RequestBody Cart cart) {
        return ResponseEntity.ok(service.updateCart(cart));
    }

    @PostMapping("/add/all")
    public ResponseEntity<List<Cart>> addAllToCart(@RequestBody List<Cart> cart) {
        return ResponseEntity.ok(service.addAllToCart(cart));
    }

    @DeleteMapping("/delete/{cartId}")
    public ResponseEntity<String> deleteById(@PathVariable int cartId) {
        return ResponseEntity.ok(service.deleteFromCart(cartId));
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<?> getCartById(@PathVariable int cartId) {
        return ResponseEntity.ok(service.getCartById(cartId));
    }
}