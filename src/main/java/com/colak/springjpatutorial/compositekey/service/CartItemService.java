package com.colak.springjpatutorial.compositekey.service;

import com.colak.springjpatutorial.compositekey.jpa.CartItemPrimaryKey;
import com.colak.springjpatutorial.dto.CartItemDTO;

import java.util.List;

public interface CartItemService {

    CartItemDTO findById(CartItemPrimaryKey cartItemPrimaryKey);

    List<CartItemDTO> findAll();

}
