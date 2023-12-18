package com.colak.springjpatutorial.compositekey.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@IdClass(CartItemPrimaryKey.class)
@Table(name = "cartitem")
public class CartItem {
    @Id
    @Column(name = "cartid", nullable = false)
    private Long cartId;

    @Id
    @Column(name = "productid", nullable = false)
    private Long productId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "count", nullable = false)
    private Long count;
}