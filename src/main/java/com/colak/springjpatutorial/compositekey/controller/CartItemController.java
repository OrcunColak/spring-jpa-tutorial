package com.colak.springjpatutorial.compositekey.controller;

import com.colak.springjpatutorial.compositekey.jpa.CartItemPrimaryKey;
import com.colak.springjpatutorial.compositekey.service.CartItemService;
import com.colak.springjpatutorial.dto.CartItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cartitem")
public class CartItemController {

    private final CartItemService cartItemService;

    @PostMapping(value = "/findbyid", consumes = "application/json", produces = "application/json")
    public CartItemDTO findById(@RequestBody CartItemPrimaryKey cartItemPrimaryKey) {
        return cartItemService.findById(cartItemPrimaryKey);
    }

    @GetMapping("/cartitems")
    public List<CartItemDTO> findAllCartItems() {
        return cartItemService.findAll();
    }
}
