package com.colak.springjpatutorial.onetomany.lazywithjoincolumn.service;

import com.colak.springjpatutorial.onetomany.lazywithjoincolumn.jpa.Author;

import java.util.List;

public interface AuthorService {

    List<Author> findAllWithBooks();
}
