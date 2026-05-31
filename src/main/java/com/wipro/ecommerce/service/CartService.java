package com.wipro.ecommerce.service;

import java.util.List;

import com.wipro.ecommerce.entity.Cart;

public interface CartService {
	public Cart addToCart(Cart cart);

	public List<Cart> getAllCartItem();

	public String updateCart(Cart cart);

	public String deleteFromCart(int cartId);

	List<Cart> addAllToCart(List<Cart> cart);

	Object getCartById(int cartId);

}
