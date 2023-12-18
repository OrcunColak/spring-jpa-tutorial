package com.colak.springjpatutorial.compositekey.service;

import com.colak.springjpatutorial.dto.CartItemDTO;

import java.util.List;

public interface CartItemService {

    List<CartItemDTO> findAll();
}
