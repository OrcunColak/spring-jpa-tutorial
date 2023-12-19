package com.colak.springjpatutorial.compositekey.service.impl;

import com.colak.springjpatutorial.compositekey.jpa.CartItemPrimaryKey;
import com.colak.springjpatutorial.compositekey.mapstruct.CartItemMapper;
import com.colak.springjpatutorial.compositekey.repository.CartItemRepository;
import com.colak.springjpatutorial.compositekey.service.CartItemService;
import com.colak.springjpatutorial.compositekey.dto.CartItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;


    @Transactional(readOnly = true)
    @Override
    public CartItemDTO findById(CartItemPrimaryKey cartItemPrimaryKey) {
        CartItemMapper cartItemMapper = CartItemMapper.INSTANCE;
        return cartItemRepository.findById(cartItemPrimaryKey)
                .map(cartItemMapper::cartItemToDTO)
                .orElseThrow();
    }

    @Transactional(readOnly = true)
    @Override
    public List<CartItemDTO> findAll() {
        CartItemMapper cartItemMapper = CartItemMapper.INSTANCE;

        return cartItemRepository.findAll()
                .stream()
                .map(cartItemMapper::cartItemToDTO)
                .toList();
    }
}
