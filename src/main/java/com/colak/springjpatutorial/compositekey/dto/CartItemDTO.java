package com.colak.springjpatutorial.compositekey.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemDTO {

    private Long cartId;

    private Long productId;

    private String name;

    private Long count;
}
