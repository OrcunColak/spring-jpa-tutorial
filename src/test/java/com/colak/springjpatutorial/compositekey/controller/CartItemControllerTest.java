package com.colak.springjpatutorial.compositekey.controller;

import com.colak.springjpatutorial.compositekey.jpa.CartItemPrimaryKey;
import com.colak.springjpatutorial.compositekey.dto.CartItemDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CartItemControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testFindById() {
        String getUrl = "/api/cartitem/findbyid";

        CartItemPrimaryKey cartItemPrimaryKey = new CartItemPrimaryKey(1L, 10L);
        CartItemDTO firstCartItem = restTemplate.postForObject(
                getUrl,
                cartItemPrimaryKey,
                CartItemDTO.class);

        assertCartItemDTO(firstCartItem);
    }

    @Test
    void testFindAllCartItems() {
        String getUrl = "/api/cartitem/cartitems";

        ResponseEntity<List<CartItemDTO>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });
        List<CartItemDTO> cartItemList = response.getBody();
        assert cartItemList != null;
        CartItemDTO firstCartItem = cartItemList.getFirst();
        assertCartItemDTO(firstCartItem);
    }

    private static void assertCartItemDTO(CartItemDTO firstCartItem) {
        assertEquals(1, firstCartItem.getCartId());
        assertEquals(10, firstCartItem.getProductId());
    }
}
