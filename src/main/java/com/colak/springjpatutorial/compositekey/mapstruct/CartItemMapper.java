package com.colak.springjpatutorial.compositekey.mapstruct;

import com.colak.springjpatutorial.compositekey.jpa.CartItem;
import com.colak.springjpatutorial.compositekey.dto.CartItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartItemMapper {

    CartItemMapper INSTANCE = Mappers.getMapper(CartItemMapper.class);

    CartItemDTO cartItemToDTO(CartItem cartItem);

    CartItem dtoToCartItem(CartItemDTO cartItemDTO);
}
