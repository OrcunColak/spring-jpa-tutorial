package com.colak.springjpatutorial.onetomany.lazywithjoincolumn.service;

import com.colak.springjpatutorial.onetomany.lazywithjoincolumn.jpa.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> findAllWithBooks();
    Optional<Author> findById(Long id);
}
