package com.colak.springjpatutorial.compositekey.repository;

import com.colak.springjpatutorial.compositekey.jpa.CartItem;
import com.colak.springjpatutorial.compositekey.jpa.CartItemPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, CartItemPrimaryKey> {

}
