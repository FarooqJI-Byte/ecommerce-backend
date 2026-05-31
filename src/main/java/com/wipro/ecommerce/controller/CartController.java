package com.wipro.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.ecommerce.entity.Cart;
import com.wipro.ecommerce.service.CartService;

@RestController
@RequestMapping("/ecommerce/cart")
public class CartController {
	@Autowired
	CartService service;

	@PostMapping("/add")
	public Cart addToCart(@RequestBody Cart cart) {
		return service.addToCart(cart);
	}

	@GetMapping("/getall")
	public List<Cart> getAllCartItem() {
		return service.getAllCartItem();
	}

	@PutMapping("update")
	public String updateCart(@RequestBody Cart cart) {
		return service.updateCart(cart);
	}

	@PostMapping("/add/all")
	public List<Cart> addAllToCart(@RequestBody List<Cart> cart) {
		return service.addAllToCart(cart);
	}

	@DeleteMapping("/delete")
	public String deleteById(@PathVariable int cartId) {
		return service.deleteFromCart(cartId);
	}

	@GetMapping
	public Object getCartById(@PathVariable int cartId) {
		return service.getCartById(cartId);
	}

}
