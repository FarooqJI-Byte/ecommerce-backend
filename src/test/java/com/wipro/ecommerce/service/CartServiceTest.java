package com.wipro.ecommerce.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wipro.ecommerce.entity.Cart;

@SpringBootTest
public class CartServiceTest {

    @Autowired
    CartService service;

    @Test
    public void testAddCart() {
        Cart cart = new Cart();
        cart.setTotalAmount(2000);

        Cart saved = service.addToCart(cart);

        assertNotNull(saved);
        assertTrue(saved.getId() > 0);
    }

    @Test
    public void testGetAllCarts() {
        List<Cart> list = service.getAllCartItem();

        assertNotNull(list);
    }

    @Test
    public void testGetCartById() {
        Cart cart = new Cart();
        cart.setTotalAmount(1500);
        Cart saved = service.addToCart(cart);

        Object result = service.getCartById(saved.getId());

        assertNotNull(result);
    }

    @Test
    public void testUpdateCart() {
        Cart cart = new Cart();
        cart.setTotalAmount(1000);
        Cart saved = service.addToCart(cart);

        saved.setTotalAmount(3000);

        String response = service.updateCart(saved);

        assertEquals("Cart updated successfully", response);
    }

    @Test
    public void testDeleteCart() {
        Cart cart = new Cart();
        cart.setTotalAmount(1200);
        Cart saved = service.addToCart(cart);

        String response = service.deleteFromCart(saved.getId());

        assertEquals("Cart successfully deleted", response);
    }
}