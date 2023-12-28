package com.colak.springjpatutorial.onetomany.lazywithjoincolumn.service.impl;

import com.colak.springjpatutorial.onetomany.lazywithjoincolumn.jpa.Author;
import com.colak.springjpatutorial.onetomany.lazywithjoincolumn.repository.AuthorRepository;
import com.colak.springjpatutorial.onetomany.lazywithjoincolumn.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;


    @Override
    public List<Author> findAllWithBooks() {
        return authorRepository.findAllWithBooks();
    }
}
