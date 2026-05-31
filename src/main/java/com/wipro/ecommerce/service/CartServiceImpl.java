package com.wipro.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.ecommerce.entity.Cart;
import com.wipro.ecommerce.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository repo;

	@Override
	public Cart addToCart(Cart cart) {
		return repo.save(cart);
	}

	@Override
	public List<Cart> getAllCartItem() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<Cart> addAllToCart(List<Cart> cart) {
		// TODO Auto-generated method stub
		return repo.saveAll(cart);
	}

	@Override
	public Object getCartById(int cartId) {
		// TODO Auto-generated method stub
		Optional<Cart> opt = repo.findById(cartId);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return "No item with the id: " + cartId;
		}
	}

	@Override
	public String updateCart(Cart cart) {
		if (cart.getId() == 0) {
			return "ID is required for update";
		}
		Optional<Cart> opt = repo.findById(cart.getId());

		if (opt.isPresent()) {
			repo.save(cart);
			return "Cart updated successfully";
		} else {
			return "No record found with id: " + cart.getId();
		}
	}

	@Override
	public String deleteFromCart(int cartId) {
		// TODO Auto-generated method stub
		Optional<Cart> opt = repo.findById(cartId);
		if (opt.isPresent()) {
			repo.deleteById(cartId);
			return "Cart deleted successfully";
		}
		return "No cart found with id: " + cartId;
	}

}
